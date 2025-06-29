# Transfer Service API

📌 Overview
A RESTful API for financial transactions including account management, funds transfer, and bank list services. Provides complete banking operations with secure authentication.

🚀 Key Features
- Account number generation
- Account information retrieval
- Bank account name enquiry
- Funds transfer between accounts
- Bank list management
- Secure API key authentication

🔐 Authentication
All endpoints require API key authentication:

Required Header:
X-API-KEY: secure-key-12345

🌐 API Endpoints

1. Account Creation
Endpoint: GET /api/account/create

Request:
GET /api/account/create
X-API-KEY: secure-key-12345

Success Response:
{
  "flag": true,
  "code": "00",
  "message": "Account Created",
  "result": "1025678901"
}

2. Get Account Information
Endpoint: POST /api/dashboard/account

Request:
POST /api/dashboard/account
X-API-KEY: secure-key-12345
Content-Type: application/json

{
  "email": "user@example.com"
}

Success Response:
{
  "flag": true,
  "code": "00",
  "message": "Account retrieved successfully",
  "result": {
    "accountName": "John Doe",
    "accountNo": "1025678901",
    "accountType": "INDIVIDUAL",
    "tier": 3,
    "balance": 3000000,
    "availableBalance": 3000000,
    "canTransfer": true
  }
}

3. Name Enquiry
Endpoint: POST /api/transfer/name-enquiry

Request:
POST /api/transfer/name-enquiry
X-API-KEY: secure-key-12345
Content-Type: application/json

{
  "bankCode": "058",
  "accountNumber": "0987654321"
}

Success Response:
{
  "flag": true,
  "code": "00",
  "result": {
    "accountName": "Michael Smith",
    "accountNumber": "0987654321",
    "bank": "GTBank"
  }
}

4. Funds Transfer
Endpoint: POST /api/transfer/create

Request:
POST /api/transfer/create
X-API-KEY: secure-key-12345
Content-Type: application/json

{
  "senderAccount": "1025678901",
  "beneficiaryAccount": "0987654321",
  "beneficiaryBankCode": "058",
  "amount": 5000,
  "narration": "June salary"
}

Success Response:
{
  "flag": true,
  "code": "00",
  "message": "Transfer Successful",
  "result": {
    "transactionId": "a1b2c3d4-e5f6-7890",
    "status": "SUCCESS",
    "message": "Transfer completed successfully"
  }
}

5. Get Bank List
Endpoint: GET /api/transfer/banks

Request:
GET /api/transfer/banks
X-API-KEY: secure-key-12345

Success Response:
{
  "flag": true,
  "code": "00",
  "message": "Successful",
  "result": [
    {
      "bankCode": "044",
      "bankName": "Access Bank"
    },
    {
      "bankCode": "058",
      "bankName": "Guaranty Trust Bank (GTB)"
    }
  ]
}

---

🧪 RAW CURL TEST CASES

# ✅ Account Creation
curl -X GET http://localhost:8091/api/account/create \
  -H "X-API-KEY: secure-key-12345"

# ✅ Get Account Information
curl -X POST http://localhost:8091/api/dashboard/account \
  -H "Content-Type: application/json" \
  -H "X-API-KEY: secure-key-12345" \
  -d '{
    "email": "user@example.com"
}'

# ✅ Name Enquiry
curl -X POST http://localhost:8091/api/transfer/name-enquiry \
  -H "Content-Type: application/json" \
  -H "X-API-KEY: secure-key-12345" \
  -d '{
    "bankCode": "058",
    "accountNumber": "0987654321"
}'

# ✅ Funds Transfer
curl -X POST http://localhost:8091/api/transfer/create \
  -H "Content-Type: application/json" \
  -H "X-API-KEY: secure-key-12345" \
  -d '{
    "senderAccount": "1025678901",
    "beneficiaryAccount": "0987654321",
    "beneficiaryBankCode": "058",
    "amount": 5000,
    "narration": "June salary"
}'

# ✅ Get Bank List
curl -X GET http://localhost:8091/api/transfer/banks \
  -H "X-API-KEY: secure-key-12345"

---

🛠️ Technical Implementation

Database Configuration:
spring.datasource.url=jdbc:postgresql://host:5432/database  
spring.datasource.username=username  
spring.datasource.password=password

Request Models

public class TransferRequest {
    private String senderAccount;
    private String beneficiaryAccount;
    private String beneficiaryBankCode;
    private Double amount;
    private String narration;
}

public class NameEnquiryRequest {
    private String bankCode;
    private String accountNumber;
}

🔧 Configuration

application.properties

spring.application.name=transfer  
server.port=8091  
app.secret-key=secure-key-12345  

🧪 Testing Data

Service          Test Data  
Name Enquiry     044:1234567890, 058:0987654321  
Transfer         Amount > 0, valid 10-digit accounts  
Bank List        Always returns full bank list  

📊 Response Codes

Code  Meaning  
00    Success  
02    Validation failure  
03    Unauthorized  
