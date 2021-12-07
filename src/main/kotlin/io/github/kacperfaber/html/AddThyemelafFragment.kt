package io.github.kacperfaber.html

class AddThyemelafFragment(var title: String, var value: Int) : ThymeleafFragment(
    "th-fragments/fragments",
    "add",
    HashMap<String, Any>().apply { this["title"] = title; this["value"] = value })