package io.github.kacperfaber.quickchart

import com.google.gson.annotations.SerializedName

class PayloadData(var labels: List<String>, @SerializedName("datasets") var dataSets: List<DataSet>)