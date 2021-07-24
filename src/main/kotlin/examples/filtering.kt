package examples

import com.fasterxml.jackson.databind.ObjectMapper


data class Report (val name:String, val service: String, var charge: Long, var vat: Long = 0)
data class Rule (val condition :String, var tax: Long)

fun main() {
    val mapper = ObjectMapper()

    val tom = Report("Tom", "SMS", 312)
    val mary = Report("mary", "DATA",132)
    val joe = Report("joe", "DATA",432)
    val peter = Report("peter", "DATA",932)
    val sue = Report("sue", "SMS",202)
    val reports = listOf(tom, mary, joe, peter, sue)

    //val jsonReports = mapper.writeValueAsString(reports)

    val tomAsString = mapper.writeValueAsString(tom)

    val condition = "$.[?(@.charge > 200 && @.service == 'DATA')]"
    val rule = Rule(condition, 10)

    val findByJsonPath = JsonPathUtils.findByJsonPath<List<Report>>( rule.condition, tomAsString )

    if (findByJsonPath.isNotEmpty()) print(true) else print(false)

    fun pathPredicate(foo: Report): Boolean = foo.service == "DATA"

    val changedReports = reports
        .filter {  pathPredicate(it) }
        //.onEach { it.charge *= 10 }
        .map { it.copy(vat = it.charge * rule.tax) }

    print(changedReports)



}


