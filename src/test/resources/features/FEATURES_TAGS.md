## REFERÊNCIA DE TAGS DAS FEATURES

Comando Maven - Com geração de Report ao Allure Report
```
mvn clean test -Dbrowser=firefox -Dcucumber.options="--tags @regressivo" -Denv=uat allure:report
```

| TAG                   | Cenário                                                   |
|-----------------------|-----------------------------------------------------------|
|@cdcPf                 |Envio de Pré-Proposta CDC PF Sem Intermediárias            |
|@cdcPfIntermediaria    |Envio de Pré-Proposta CDC PF Com Intermediárias            |
|@cdcPj                 |Envio de Pré-Proposta CDC PJ Sem Intermediárias            |
|@cdcPjIntermediaria    |Envio de Pré-Proposta CDC PJ Com Intermediárias            |
|@cicloPf               |Envio de Pré-Proposta Ciclo PF                             |
|@cicloPj               |Envio de Pré-Proposta Ciclo PJ                             |
|@fichaPf               |Envio de Pré-Proposta - Variações na Ficha Cadastral PF    |
|@fichaPj               |Envio de Pré-Proposta - Variações na Ficha Cadastral PJ    |
