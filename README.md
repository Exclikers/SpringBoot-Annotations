# SpringBoot-Annotations
# CRUD Controller

PERSON
GET - List All Person = /api/person
GET - List Person by Id = /api/person/{id}
POST - Create Person = /api/person
PUT - Update Person = /api/person/{id}
DELETE - Delete Person = /api/person/{id}
PUT - Add Person Role = /api/person/{id}/role/{id}
DELETE - Delete Person Role = /api/person/{id}/role/{id}

CONTACT
GET - List All Contacts = /api/contacts
GET - List Contact by Person = /api/person/{id}/contact
POST - Add Contact = /api/person/{id}/contact
PUT - Update Contact = /api/person/{id}/contact/{id}
DELETE - Delete Contact = /api/person/{id}/contact/{id}

ROLE
GET - List All Role = /api/role
POST - Add Role = /api/role
PUT - Update Role = /api/role/{id}
DELETE - Delete Role = /api/role/{id}

*PERSON*
{
    "title": "",
    "firstName": "",
    "lastName": "",
    "middleName": "",
    "suffix": "",
    "streetNumber": 0,
    "barangay": "",
    "municipality": "",
    "zipcode": 0,
    "birthdate": "yyyy-MM-dd",
    "gradeWeightedAverage": 00.0,
    "dateHired": "yyyy-MM-dd",
    "employmentStatus": "Employed"
}

*CONTACT*
{
    "landline": "",
    "mobile": "",
    "email": ""
}

*ROLE*
{
   "role": ""
}






