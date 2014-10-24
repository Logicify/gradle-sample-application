databaseChangeLog = {

	changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413927937199-1") {
		addColumn(tableName: "user") {
			column(name: "passwd", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413927937199-2") {
		dropIndex(indexName: "UK_IRSAMGNERA6ANGM0PRQ1KEMT2", tableName: "ROLE")
	}

	changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413927937199-3") {
		dropIndex(indexName: "USERNAME_UNIQ_1413924026039", tableName: "USER")
	}

	changeSet(author: "LOGICIFY\\corvis (generated)", id: "1413927937199-4") {
		dropColumn(columnName: "PASSWORD", tableName: "USER")
	}
}
