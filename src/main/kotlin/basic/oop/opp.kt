package main.oop

class SqlQuery1 constructor(sqlDialect: String)

class SqlQuery2 (sqlDialect: String)

class SqlQuery3 (sqlDialect: String){
    val _sqlDialect = sqlDialect
}

class SqlQuery4 (val sqlDialect: String)

class SqlQuery5 (val sqlDialect: SqlDialect)

class SqlDialect(val name: String){
    val isDefault: Boolean
        get() {
            return "" == name
        }
}