dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
                dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    /*test {
        // DEMO EMBEDDED DATA SOURCE (INSTEAD OF USING THE JNDI DATA SOURCE)
        dataSource {
            pooled = true // one of 'create', 'create-drop', 'update', 'validate', ''
            dbCreate = "create-drop"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'

            // CLOUDBEES INJECTS BOUND DATABASES CONNECTION PARAMETERS WITH SYSTEM PROPERTIES
            // for a database binding alias "mydb", system properties look like DATABASE_XXX_MYDB
            // see CloudBees SDK : "bees app:bind -a my-grails-application -db my-database -as mydb"
            // see http://wiki.cloudbees.com/bin/view/RUN/Resource+Management
            url = "jdbc:" + System.getProperty('DATABASE_URL_MYDB')
            username = System.getProperty('DATABASE_USERNAME_MYDB')
            password = System.getProperty('DATABASE_PASSWORD_MYDB')

            properties {
                maxActive = 20
                maxIdle = 1
                maxWait = 10000

                removeAbandoned = true
                removeAbandonedTimeout = 60
                logAbandoned = true

                validationQuery = "SELECT 1"
                testOnBorrow = true
            }
        }
    }

    production {
        // DEMO JNDI DATA SOURCE
        dataSource {
            dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            pooled = false

            dbCreate = 'update' // WARNING! on production, should probably be 'update' or 'validate'
            jndiName = 'java:comp/env/jdbc/mydb'
        }
    }*/
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
        }
    }
}
