# Api Details

## User Service API:
- POST /users/register: Register a new user.
- POST /users/login: Login user and generate authentication token.
- GET /users/{userId}: Retrieve user details.
- PUT /users/{userId}: Update user details.
- DELETE /users/{userId}: Delete user account.

## Task Service API:
- POST /tasks: Create a new task.
- GET /tasks/{taskId}: Retrieve task details.
- PUT /tasks/{taskId}: Update task details.
- DELETE /tasks/{taskId}: Delete a task.
- GET /tasks/user/{userId}: Retrieve tasks assigned to a user.
- GET /tasks/team/{teamId}: Retrieve tasks assigned to a team.

## Team Service API:
- POST /teams: Create a new team.
- GET /teams/{teamId}: Retrieve team details.
- PUT /teams/{teamId}: Update team details.
- DELETE /teams/{teamId}: Delete a team.
- POST /teams/{teamId}/members: Add a member to a team.
- DELETE /teams/{teamId}/members/{userId}: Remove a member from a team.
- GET /teams/{teamId}/members: Retrieve team members.

## Notification Service API:
- POST /notifications: Send a notification.
- GET /notifications/{notificationId}: Retrieve notification details.
- DELETE /notifications/{notificationId}: Delete a notification.
- GET /notifications/user/{userId}: Retrieve notifications for a user.




# Database Schema

## User Table
- UserId (Primary Key)
- Username
- Email
- Password
- ...

## Task Table
- TaskId (Primary Key)
- Title
- Description
- AssignedUserId (Foreign Key to User)
- TeamId (Foreign Key to Team)
- Deadline
- Status
- ...

## Team Table
- TeamId (Primary Key)
- Name
- Description
- ...

## Team Members Table
- TeamId (Foreign Key to Team)
- UserId (Foreign Key to User)
- ...

## Notification Table
- NotificationId (Primary Key)
- UserId (Foreign Key to User)
- Message
- Timestamp
- ...
