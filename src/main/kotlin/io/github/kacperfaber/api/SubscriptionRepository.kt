package io.github.kacperfaber.api

import org.hibernate.SessionFactory
import org.springframework.stereotype.Component

@Component
class SubscriptionRepository(var factory: SessionFactory) {
    fun get(id: Int): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["id"] = id
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.id = :id", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    fun save(s: Subscription): Int{
        val sess = factory.openSession()
        sess.beginTransaction()
        val id = sess.save(s) as Int
        sess.close()
        return id
    }

    fun getByEmail(email: String): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["email"] = email
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.email = :email", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    fun getNotConfirmedByEmail(email: String): Subscription? {
        val sess = factory.openSession()
        sess.beginTransaction()
        val map = HashMap<Any, Any>()
        map["email"] = email
        val resultList =
            sess.createQuery("FROM Subscription S WHERE S.email = :email AND S.confirmedAt IS NULL", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }

    fun saveOrUpdate(s: Subscription) {
        val sess = factory.openSession()
        sess.beginTransaction()
        sess.update(s)
        sess.close()
    }
}