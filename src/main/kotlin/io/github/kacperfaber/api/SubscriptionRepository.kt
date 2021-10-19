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
        val resultList = sess.createQuery("FROM Subscription S WHERE S.id = :id", Subscription::class.java).setProperties(map).resultList
        sess.close()
        return resultList.getOrNull(0)
    }
}