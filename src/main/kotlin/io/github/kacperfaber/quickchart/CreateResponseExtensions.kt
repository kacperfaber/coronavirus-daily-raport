package io.github.kacperfaber.quickchart

fun CreateResponse?.toNullableUrl(): ChartUrl? = if (this?.url != null) ChartUrl(this.url) else null

fun CreateResponse?.toUrl() = ChartUrl(this!!.url)