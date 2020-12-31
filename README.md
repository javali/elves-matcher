# elves-matcher
Matching utility between local legal form abbreviations and the corresponding GLEIF ELF-code.

-----
### Usages:

#### Use as REST Service
```
curl --location --request POST 'http://localhost:8084/convert' \
--header 'Content-Type: application/json' \
--data-raw '
    {
        "legislation": "DE",
        "abbreviation": "REIT-AG"
    }
'
```

#### Command line: convert a given legal form to an elf-code
```
usage: ElvesMatcher.jar
    --convert <GmbH>     local abbreviation to convert
    --legislation <DE>   legislation of the abbreviation  
2HBR
```
#### Command line: update definition
In case a new elf-code list is published, place it into /src/main/resources and build the jar. 
Please note that only one version of the elf-code-list may be places in this directory.
```
ElvesMatcher.jar --update [name-of-elf-code-list.csv]  
```

