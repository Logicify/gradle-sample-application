Just random useful notes
========================

1) System build process is fully managed by gradle. 
Thus if you need to run any grails command like ```grails dbm-update``` you need to use the following convention:
```
gradle grails-COMMAND_NAME -PgrailsArgs="ARGUMENTS"
```

where command name is a grails command you whant to run. e.g.
```
gradle grails-dbm-update
```

If you need to pass some parameters use ```-PgrailsArgs``` option. E.g.
```
gradle grails-s2-quickstart -PgrailsArgs="--uiOnly"
```

2) Usefull commands

NOTE: Folowing commands should be run from gtp-web/ dir or prefixed by "gtp-web:" like ```gradle gtp-web:run``` if you whould like to run from root (gtp dir).

gradle clean - remove all temp files
gradle build - compile project
gradle war - compile and prepare WAR file
gradle run - run debug embedded service


3) Database migrations:
gradle grails-dbm-update - to apply migrations on you DB
gradle grails-dbm-changelog-sync - if you are already have DB synchronized with code, and just need to mark all chengesets as applied
gradle grails-dbm-gorm-diff -PgrailsArgs="--add YOUR-MIGRATION-NAME.groovy" - to create a new changeset which includes only diff between current DB state and your domain.
