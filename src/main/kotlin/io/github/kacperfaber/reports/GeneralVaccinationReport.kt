package io.github.kacperfaber.reports

@Suppress("unused")
class GeneralVaccinationReport {
    var vaccinations: Int = 0
    var firstDoses: Int = 0
    var secondDoses: Int = 0
    var adverseReactions: Int = 0
    var vaccinesDeliveredToPL: Int = 0
    var vaccinesDeliveredToPoints: Int = 0
    var availabilityInStock: Int = 0
    var ordersInProgress: Int = 0
    lateinit var ageTypes: Array<VaccinationAgeType>
}