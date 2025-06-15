# Asset_Management
 Spring boot REST based app for asset management for company. 


Problem Description:

Any company has assets like laptops, keyboard, stationary items, furniture etc. It is important for a company to keep a track of these assets, their condition,
and assignment to people to ensure rightful use of these assets and keep a track of them.  A REST based app is required which will expose the following services :

Add category of assets. Categories can be like - electronics, furniture etc. A category will have a unique ID, name and description
Update category 
List of all categories 
Add an asset. Asset will have a name, purchase date, condition notes, a category, assignment status - Available, Assigned, Recovered. 
List of assets
Search assets based on name 
Update an asset. 
Assign an asset to an employee 
Recover an asset from an employee 
Delete an asset.  The rules here are : An asset cannot be delete which is in assigned state 
Assume that employees are already there in the database with the following information about them - id (unique id of the employee), full name, designation

Tech Stack to be used:

Spring boot 2.4 
Spring JPA
H2 Database 
Source code management in Github 
Things to consider:

Clean code with functional solidity and completeness
Documented code with clear description  on how things work ( Javadocs and README.md )
Unit Test cases using JUNIT5 and Spring Boot Tests and Mockito 


=============================================================================SOLUTION===========================================================================
Application Name --> AssetmanagementApplication
This aaplication consist of two controllers 'CompanyAssetCategoryManagement' and 'CompanyAssetManagement'.

Swagger UI - http://localhost:8080/swagger-ui/index.html#/
http://localhost:8080/h2-console/login.do?jsessionid=ebce42c02578450f1c338901e9081a6c


1. Controller --> 
Class: CompanyAssetCategoryManagement
Base Path: / (no prefix)

This controller handles the management of asset categories.

📌 Endpoints
[Method] 	  [URL]	 -             [Description]	                        [Request Body]
POST     	/add	       Add a new asset category	Category            JSON
PATCH	   /update	     Update an existing asset category            JSON
GET	     /gelAll	     Get all asset categories	None                None

--------------------------------------------------------------------------------------------------------------------------------
2. Controller --> 
Class: CompanyAssetManagement
Base Path: /asset

This controller manages assets owned by the company, including assigning them to employees and recovering them.

📌 Endpoints
[Method] 	  [URL]	 -                    [Description]	                                [Request Body]
POST     	/add	                       Add a new asset category	Category                (Asset)JSON
PATCH	   /update/{id}	                Update an existing asset category                Path: id, Body: Asset(JSON)
GET	     /searchAsset/{assetName}	    Get all asset categories	None                    Path: assetName
GET      /getAll                      Retrieve all assets                              None
PATCH    /assignAsset                 Assign an asset to an employee                   Query: assetId, empId
PATCH    /recover/{assetId}           Recover (unassign) an asset                      Path: assetId
DELETE   /delete/{assetId}            Delete an asset by ID                            Path: assetId

-----------------------------------------------------------------------------------------------------------------------------------------
🔍 Notes:
Each action is logged for traceability.
The assignAsset and recoverAsset methods are used to manage asset assignment lifecycle.
deleteAsset performs a logical or physical delete based on the service logic.

---------------------------------------------
controller --> CompanyAssetCategoryManagement, CompanyAssetManagement
services -->  AssetManagementService, CategoryManagementService
models --> Asset, Category, Employee.
Enum --> AssignmentStatus, CategoryTypes

-----------------------------------------------------------------------------------------------
✅ JUnit Test Coverage
The application includes JUnit 5 test cases for controller-level testing using MockMvc and Mockito. These test cases verify:
Successful creation and update of categories and assets.
Retrieval of lists (assets/categories).
Assignment and recovery of assets.
Handling of invalid update scenarios.
Correct HTTP status codes and response formats.

----------------------------------------------------------------------------------------------
🔧 Technologies Used
Spring Boot (REST Controllers, Dependency Injection)
JUnit 5 (Unit Testing)
Mockito (Service Layer Mocking)
MockMvc (Controller Testing)
Lombok (for cleaner model code, if used)
SLF4J / Log4j (Logging)
H2 Database
SwaggerUI.

-----------------------------------------------------
Remaining part --> 
Exception Handler is remaining, However I created the controller advice class, there I covered generic exception, but other exception is remaining.
