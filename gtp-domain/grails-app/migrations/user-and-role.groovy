databaseChangeLog = {

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-2") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-3") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-4") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-5") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-8") {
        createIndex(indexName: "UK_irsamgnera6angm0prq1kemt2", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-9") {
        createIndex(indexName: "authority_uniq_1413924026026", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-10") {
        createIndex(indexName: "UK_sb8bbouer5wak8vyiiy4pf2bx", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-11") {
        createIndex(indexName: "username_uniq_1413924026039", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-6") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413924026096-7") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }
}
