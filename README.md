# Bank System
an Object Oriented Programming team project before the mid-exam  

Professor:  
D6421 - MUHAMMAD FIKRI HASANI, S.Kom., M.T.  

Students:  
2440022826 - MICHAEL LEONARDO  
2440022681 - GABRIEL JEHUDA  

### Case 
---
A random bank manages two types of accounts, a basic account and a strict account. Strict accounts withhold a quota of Rp1,000,000 that mustn’t be withdrawn below the amount and a minimum balance of Rp100,000 to be deposited into the account, essentially restricting the user’s control. A basic account does not possess these limitations and can freely deposit or withdraw any amount of money they desire, within reason.  

### Class analysis
Client.java registers and stores clients’ names, addresses, and telephone numbers. It is the parent class.  
Account.java client data storage with the added balance and ID information. It has an aggregate relationship with the client class.  
StrictAccount.java is identical to Account.java with the inclusion of a minimum balance for the Rp1,000,000 quota. It has both an aggregate and compositional relationship with the account and client class.  
BankSystem.java is the main file of the program.  

### Contribution
Case  
Study: Gabriel & Michael  
Class Analysis: Gabriel  
Class Diagram: Michael  
  
Coding  
class Client.java: Gabriel  
class Account/StrictAccount.java: Michael  
class BankSystem.java: Gabriel & Michael  
