# Data Flow Diagram

## Overview
The Data Flow Diagram (DFD) illustrates how data moves through the QN Tech system, highlighting the interactions between various components and the flow of information.

## DFD Levels
### Level 0: Context Diagram
- Represents the entire system as a single process.
- Shows external entities such as users, banks, and businesses interacting with the system.

### Level 1: High-Level DFD
- Breaks down the main process into sub-processes:
  - **User  Interaction**: Users submit requests through the UI.
  - **Data Processing**: Data is processed by the Data Service and Analytics Service.
  - **Contract Management**: Smart contracts are executed and validated.
  - **Security Management**: Security Service handles encryption and key management.

### Level 2: Detailed DFD
- Provides a detailed view of data flow within each sub-process:
  - **User  Interaction**:
    - User submits transaction data → API Gateway → Security Service for validation.
  - **Data Processing**:
    - Validated data → Data Service → Database for storage.
    - Data retrieved → Analytics Service for processing → Results sent to UI.
  - **Contract Management**:
    - Contract requests → Contract Service → Smart contract execution → Results sent to UI.
  - **Security Management**:
    - Data encryption requests → Security Service → Encrypted data sent to Data Service.

## Conclusion
The DFD provides a clear visualization of how data flows through the QN Tech system, ensuring that all components work together seamlessly to provide secure and efficient banking and business integration.
