# BugTrackingSystem

Bug Tracking System.

I Used : Spring Boot  , Hibernate JPA.
Additional :
  1- I Used Single Responsability , Interface Segregation From SOLID.
  2- I Follow All Rules For Clean Code.
  
  
 System : 
 Login : 
    For Admin , Develoeper  , tester 
    By Email And Password 
    if(developer || admin || tester ==> forget Password )-> person enter his email if email exist ==> system send message for this gmail tell him a his password.
 1- Admin: 
    Manage Developers (add , update , delete , view all)
    Manage Testers (add , update , delete , view , all)
    Manage Projects (add , update , delete , view all  , assign project for one developer and one tester).
 #When Admin Assiign Project For Developer And Tester # ==> system send message for developer gmail and tester gmail to tell them there are new project for you.
 
 2- Tester : 
    Manage Project Bugs(add  , update  , delete  ,send it for developer)== > when tester find bugs his bonus increase ==> Admin Can View Tester Bonus To Know This Tester Is A Good Tester.
     #When Tester Assign Bug For Developer # ==> System Send Message For Developer Tell Him There Are A New Bug From Tester a To You.
     
 3- Developer : 
    Solve Bugs(when he solve bugs its bonus increase).
    Close Bug.==> System Send Message For Tester To Tell Him This Developer Closed This Bug To Check Again About This Closed Bug.
    
