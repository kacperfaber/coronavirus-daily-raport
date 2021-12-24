package io.github.kacperfaber.api

import org.hibernate.SessionFactory
import org.springframework.stereotype.Component

@Component
open class SubscriptionRepository(var factory: SessionFactory) {
    open fun get(id: Int): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["id"] = id
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.id = :id", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    open fun save(s: Subscription): Int {
        val sess = factory.openSession()
        sess.beginTransaction()
        val id = sess.save(s) as Int
        sess.close()
        return id
    }

    open fun getByEmail(email: String): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["email"] = email
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.email = :email", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    open fun getByEmailAndCancelCode(email: String, cancelCode: String): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["email"] = email
        map["code"] = cancelCode
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.email = :email AND S.cancelCode = :code", Subscription::class.java)
                .setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    open fun getNotConfirmedByEmail(email: String): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["email"] = email
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.email = :email AND S.confirmedAt IS NULL", Subscription::class.java)
                .setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    open fun saveOrUpdate(s: Subscription) {
        val sess = factory.openSession()
        sess.beginTransaction()
        sess.update(s)
        sess.close()
    }

    open fun getActiveEmails(): List<String> {
        val sess = factory.openSession()
        sess.beginTransaction()
        val r = sess.createQuery(
            "FROM Subscription S WHERE S.confirmedAt IS NOT NULL AND S.canceledAt IS NULL",
            Subscription::class.java
        ).resultList
        sess.close()
        return r.map { x -> x.email }
    }

    open fun getActiveSubscriptions(): List<Subscription> {
        val sess = factory.openSession()
        sess.beginTransaction()
        val r = sess.createQuery(
            "FROM Subscription S WHERE S.confirmedAt IS NOT NULL AND S.canceledAt IS NULL",
            Subscription::class.java
        ).resultList
        sess.close()
        return r
    }
}