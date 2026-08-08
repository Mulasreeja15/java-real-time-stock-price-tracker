# Loan Management UML & Real-Time DIA Price Tracker

## Overview

This project contains two technical tasks:

1. A UML State Diagram for a loan management system.
2. A Java application that retrieves the latest DIA price every 15 seconds using the Twelve Data API and stores each result in a queue.

The project demonstrates system modeling, Java programming, API integration, queue data structures, timestamp handling, and basic data visualization.

---

## Part 1: Loan Management UML State Diagram

The UML State Diagram represents the lifecycle of a loan application from submission to closure.

The main states include:

- Application Started
- Application Submitted
- Initial Review
- Credit / Risk Assessment
- Approved
- Rejected
- Documentation
- Loan Agreement
- Funds Disbursed
- Repayment
- Loan Closed

The diagram also includes guard conditions for approval and rejection decisions.

A rejected applicant can update the application and resubmit it.

After funds are disbursed, the loan moves into repayment instead of returning to the rejection state.

### Example Flow

```text
Start
  ↓
Application Submitted
  ↓
Initial Review
  ↓
Credit / Risk Assessment
  ↓
Decision
 ↙      ↘
Rejected  Approved
   ↓        ↓
Resubmit  Documentation
             ↓
        Loan Agreement
             ↓
       Funds Disbursed
             ↓
          Repayment
             ↓
         Loan Closed
```
The Java application retrieves the latest price of DIA from the Twelve Data API.

The program:

Calls the Twelve Data API
Retrieves the DIA price
Captures the current timestamp
Stores the result in a Java Queue
Waits 15 seconds
Repeats the process
Application Flow
Java Application
      ↓
Twelve Data API
      ↓
Retrieve DIA Price
      ↓
Capture Timestamp
      ↓
Store Result in Queue
      ↓
Wait 15 Seconds
      ↓
Repeat

Technologies Used
Java 17
Google Colab
Twelve Data API
Java HttpClient
Queue
LinkedList
LocalDateTime
Python
Pandas
Matplotlib
Java Queue

The application uses a Queue to store the collected data.

Queue<String> priceQueue = new LinkedList<>();

A Queue follows the FIFO principle:

First In, First Out

Each queue entry contains:

Timestamp + DIA Price

Example:

Timestamp: 2026-08-08T03:14:16
DIA Price: 539.59998
API Integration

The application uses the Twelve Data API endpoint:

https://api.twelvedata.com/price?symbol=DIA&apikey=YOUR_API_KEY

The API key is stored securely as an environment variable.

String apiKey = System.getenv("TWELVE_DATA_API_KEY");

This prevents the API key from being exposed in the source code.

Running the Java Application

Compile the Java file:

javac App.java

Run the application:

java App

The program retrieves a new DIA price approximately every 15 seconds.

Sample Output
Timestamp: 2026-08-08T03:14:16
DIA Price: {"price":"539.59998"}

Timestamp: 2026-08-08T03:14:31
DIA Price: {"price":"539.59998"}

Timestamp: 2026-08-08T03:14:47
DIA Price: {"price":"539.59998"}
Data Visualization

The collected Java output can be processed using Python.

Pandas is used to organize the timestamp and price data, while Matplotlib is used to visualize DIA price movement over time.

The resulting graph displays:

Timestamp on the X-axis
DIA price on the Y-axis
Project Structure
project/
│
├── README.md
├── App.java
├── UML-State-Diagram.png
└── dia-price-analysis.ipynb
Key Skills Demonstrated
UML State Diagram Design
Business Process Modeling
Java Programming
REST API Integration
HTTP Requests
Queue Data Structures
Real-Time Data Collection
Timestamp Handling
Secure API Key Management
Python Data Analysis
Data Visualization
Security

The Twelve Data API key is not included in this repository.

Users should create their own Twelve Data API key and store it as an environment variable before running the application.

![Loan Management UML State Diagram](UML-State-Diagram.png)
<img width="1536" height="1024" alt="state diagram" src="https://github.com/user-attachments/assets/49004e33-5f2b-4107-9151-3c856ea50be2" />

And your graph under the visualization section using:

![DIA Price Over Time](dia-price-chart.png)
<img width="988" height="490" alt="image" src="https://github.com/user-attachments/assets/67fa25e8-4671-4adf-96d8-2bda237ea9f3" />
