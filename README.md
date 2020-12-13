# elves-matcher
Matching utility between local legal form abbreviations and the corresponding GLEIF ELF-code.

-----
### Usages:
#### Convert a given legal form to an elf-code
```
ElvesMatcher.jar --legislation DE --convert GmbH  
2HBR
```
#### Update definition
In case a new elf-code list is published, place it into /src/main/resources and build the jar. 
Please note that only one version of the elf-code-list may be places in this directory.
```
ElvesMatcher.jar --update [name-of-elf-code-list.csv]  
```

