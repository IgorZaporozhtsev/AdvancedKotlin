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

    val condition = "$.[?(@.charge > 200 && @.service == 'DATA')]"
    val rule = Rule(condition, 10)


    fun pathPredicate(report: Report): Boolean {
        val reportAsString = mapper.writeValueAsString(report)
        val findByJsonPath = JsonPathUtils.findByJsonPath<List<Report>>( rule.condition, reportAsString )
        return findByJsonPath.isNotEmpty()
    }

    val changedReports = reports
        .filter { report -> pathPredicate(report) }
        .map { report ->  report.copy(vat = report.charge * rule.tax) }

    print(changedReports)



}


