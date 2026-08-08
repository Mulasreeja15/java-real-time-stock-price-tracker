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
