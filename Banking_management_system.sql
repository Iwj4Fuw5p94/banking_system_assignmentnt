-- Tasks 1: Database Design (Normalization):
-- Task1, Q.1  Create the database named "HMBank"

create database HMBank;
use HMBank;
-- Task1, Q.2  Define the schema for the Customers, Accounts, and Transactions tables based on the provided schema.
-- Database Tables

CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    DOB DATE,
    email VARCHAR(100),
    phone_number VARCHAR(20),
    address VARCHAR(255)
);
alter table customer(
add constrants customer_id foreign key
)
-- Create the Transactions table ,foreign key is customer id reference by customers table 
create table Accounts(
account_id int primary key,
customer_id int,
account_type varchar(20),
balance decimal(10,2),
foreign key(customer_id)references customers(customer_id)
);


-- Create the Transactions table
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(20),
    amount DECIMAL(10, 2),
    transaction_date DATE,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);
-- Task1, Q.3 Completed 
-- Task1, Q.4 Completed 
-- Task1, Q.5
-- Adding Foreign Key Constraints
ALTER TABLE Accounts
ADD CONSTRAINT FK_Customer_Account
FOREIGN KEY (customer_id) REFERENCES Customers(customer_id);

ALTER TABLE Transactions
ADD CONSTRAINT FK_Account_Transaction
FOREIGN KEY (account_id) REFERENCES Accounts(account_id);
select * from accounts;
-- Task 2 completed 

-- Tasks 3: Data Manipulation Language (DML):
-- Q.1Insert sample records into the Customers table
-- Insert sample records into the Customers table
INSERT INTO Customers (customer_id, first_name, last_name, DOB, email, phone_number, address)
VALUES
(1, 'John', 'Doe', '1990-05-15', 'john.doe@email.com', '1234567890', '123 Main St'),
(2, 'Jane', 'Smith', '1985-08-20', 'jane.smith@email.com', '9876543210', '456 Oak St'),
(3, 'Robert', 'Johnson', '1992-03-10', 'robert.johnson@email.com', '5551112222', '789 Pine St'),
(4, 'Emily', 'Williams', '1988-12-05', 'emily.williams@email.com', '3334445555', '101 Elm St'),
(5, 'David', 'Brown', '1995-06-25', 'david.brown@email.com', '9998887777', '202 Cedar St'),
(6, 'Amanda', 'Miller', '1980-09-18', 'amanda.miller@email.com', '6667778888', '303 Birch St'),
(7, 'Michael', 'Wilson', '1998-02-28', 'michael.wilson@email.com', '1112223333', '404 Oak St'),
(8, 'Jessica', 'Jones', '1983-07-15', 'jessica.jones@email.com', '7776665555', '505 Maple St'),
(9, 'Daniel', 'Taylor', '1994-11-30', 'daniel.taylor@email.com', '4445556666', '606 Pine St'),
(10, 'Sophia', 'Clark', '1986-04-22', 'sophia.clark@email.com', '2223334444', '707 Cedar St');
INSERT INTO Customers (customer_id, first_name, last_name, DOB, email, phone_number, address)
VALUES
(12, 'ir', 'ams', '1908-11-01', 'ily.liams@email.com', '4334435555', 'aanglore');


-- Insert sample records into the Accounts table
INSERT INTO Accounts (account_id, customer_id, account_type, balance)
VALUES
(101, 1, 'savings', 5000.00),
(102, 1, 'current', 2000.00),
(103, 2, 'savings', 8000.00),
(104, 2, 'current', 3500.00),
(105, 3, 'savings', 6000.00),
(106, 3, 'current', 1200.00),
(107, 4, 'savings', 3000.00),
(108, 5, 'savings', 9000.00),
(109, 6, 'current', 4000.00),
(110, 7, 'savings', 7500.00);

-- Insert sample records into the Transactions table
INSERT INTO Transactions (transaction_id, account_id, transaction_type, amount, transaction_date)
VALUES
(1001, 101, 'deposit', 1000.00, '2023-01-15'),
(1002, 102, 'withdrawal', 500.00, '2023-02-01'),
(1003, 103, 'deposit', 2000.00, '2023-02-10'),
(1004, 104, 'withdrawal', 1000.00, '2023-03-05'),
(1005, 105, 'deposit', 1500.00, '2023-04-20'),
(1006, 106, 'withdrawal', 300.00, '2023-05-12'),
(1007, 107, 'deposit', 800.00, '2023-06-08'),
(1008, 108, 'withdrawal', 1200.00, '2023-07-15'),
(1009, 109, 'deposit', 700.00, '2023-08-22'),
(1010, 110, 'withdrawal', 2000.00, '2023-09-30');

select * from accounts;
select * from customers;
select * from Transactions;

-- Tasks 3: Data Manipulation Language (DML):
-- Q1. Write a SQL query to retrieve the name, accounttype and email of all customers.
SELECT
    CONCAT(first_name, ' ', last_name) AS full_name,
    email,
    account_type
FROM
    Customers
JOIN
    Accounts ON Customers.customer_id = Accounts.customer_id;
    
-- Q2 Write a SQL query to list all transaction corresponding customer
select
 T.transaction_id,
    T.account_id,
    T.transaction_type,
    T.amount,
    T.transaction_date,
    C.first_name,
    C.last_name,
    C.email
	from
		Customers C
	join
		Accounts A ON C.customer_id=A.customer_id
        join
		Transactions T ON T.account_id=A.account_id;
-- Q.3  Write a SQL query to increase the balance of a specific account by a certain amount.
update Transactions 
	set 
		amount=amount+1000
	where 
		transaction_id=1001;
-- Q.4 Write a SQL query to Combine first and last names of customers as a full_name.

select concat(first_name,'',last_name) as full_name from customers;

-- Q.5 Write a SQL query to remove accounts with a balance of zero where the account type is savings
delete from accounts
	where
		balance=0
	and
		account_type='saving';

-- Q.6. Write a SQL query to Find customers living in a specific city
SET @address = 'banglore';

-- Use the parameter in the query
SELECT *
FROM Customers
WHERE address = @address;
-- Q.7. Write a SQL query to Get the account balance for a specific account.
set @balance='2000';
select * from accounts where balance=@balance;
-- we can also acheive this by using his query--SELECT balance FROM accounts WHERE account_number = '1239';
-- Q.8 8. Write a SQL query to List all current accounts with a balance greater than $1,000.
SELECT balance, account_type
FROM accounts
WHERE balance > 1000 AND account_type = 'current';
-- Q.9 Write a SQL query to Retrieve all transactions for a specific account.

select * from transactions t join accounts a
 on  a.account_id=t.account_id where
 account_type='current';

-- q.10 Write a SQL query to Calculate the interest accrued on savings accounts based on a given interest rate.
-- Assuming  interest rate bcoz there is no interest rate column in the accounts table we can also set interest rate varaible 
SELECT
    account_id,
    balance,
    account_type,
    balance * (0.02) AS interest_accrued
FROM
    Accounts 
WHERE
    account_type = 'savings';

-- Q.11. Write a SQL query to Identify accounts where the balance is less than a specified overdraft limit.
set @overdraft='10000';

select * from accounts
where balance<@overdraft;     -- 1000 assume the  overdraft limit ,we can replace the actual limit 

-- Q.12  Write a SQL query to Find customers not living in a specific city.
set @specific_city='banglore';
select * from Customers where address<>@specific_city;

-- Tasks 4: Aggregate functions, GroupBy and Joins:

-- Q.1 Write a SQL query to Find the average account balance for all customers. 
select avg(balance) as average_balance from accounts;

-- Q.2.Write a SQL query to Retrieve the top 10 highest account balances.
select * from accounts order by balance desc limit 10;

-- Q.3Write a SQL query to Calculate Total Deposits for All Customers in specific date.
select * from customers;
select * from accounts;
select * from transactions;
set @specific_date='2023-02-10';
select transaction_id, sum(amount) from transactions where transaction_type='deposit' 
and  transaction_date=@specific_date group by transaction_id;
-- Q.4 Write a SQL query to Find the Oldest and Newest Customers.

-- 4(i) a SQL query to Find the Oldest Customers.
select concat(first_name,' ',last_name) as full_name,t.transaction_date
 from customers c join Accounts A on c.customer_id=a.customer_id
 join transactions t on t.account_id=a.account_id order by transaction_id asc;
 
 -- 4(ii) a SQL query to Find the  Newest Customers.
 select concat(first_name,' ',last_name) as full_name,t.transaction_date
 from customers c join Accounts A on c.customer_id=a.customer_id
 join transactions t on t.account_id=a.account_id order by transaction_id desc;
 
 -- Q.5Write a SQL query to Retrieve transaction details along with the account type.
 select concat(first_name,' ',last_name) as full_name,t.transaction_date,
 t.transaction_id,t.transaction_type,t.amount from customers c join Accounts A on c.customer_id=a.customer_id
 join transactions t on t.account_id=a.account_id;

 -- also write this select * from transactions;
 
 -- Q.6 Write a SQL query to Get a list of customers along with their account details
 select * from customers;
select * from accounts;
select * from transactions;
 select concat(first_name,' ',last_name) as full_name,c.customer_id,a.account_type,a.balance,c.dob
 from customers c join accounts a on a.customer_id=a.customer_id;
 


-- Q.7. Write a SQL query to Retrieve transaction details along with customer
-- information for a specific account.
set @specific_account='current';-- you can take any account it is all upto u
 select concat(first_name,' ',last_name) as full_name,c.customer_id,
    c.DOB,
    c.email,
    c.phone_number,
    c.address,a.account_type,t.transaction_date,t.transaction_type
 from customers c join Accounts A on c.customer_id=a.customer_id
 join transactions t on t.account_id=a.account_id where account_type=@specific_account;




-- Q8. Write a SQL query to Identify customers who have more than one account.
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    COUNT(a.account_id) AS num_accounts
FROM
    Customers c
JOIN
    Accounts a ON c.customer_id = a.customer_id
GROUP BY
    c.customer_id, c.first_name, c.last_name
HAVING
    COUNT(a.account_id) > 1;

-- 9. Write a SQL query to Calculate the difference in transaction amounts between 
-- deposits and withdrawals.
SELECT
    account_id,
    SUM(CASE WHEN transaction_type = 'deposit' THEN amount ELSE 0 END) AS total_deposits,
    SUM(CASE WHEN transaction_type = 'withdrawal' THEN amount ELSE 0 END) AS total_withdrawals,
    SUM(CASE WHEN transaction_type = 'deposit' THEN amount ELSE -amount END) AS net_difference
FROM
    Transactions
GROUP BY
    account_id;
    select * from transactions;
    
    
SELECT
    account_id,
    SUM(CASE WHEN transaction_type = 'deposit' THEN amount ELSE 0 END) AS total_deposits,
    SUM(CASE WHEN transaction_type = 'withdrawal' THEN amount ELSE 0 END) AS total_withdrawals,
    GREATEST(SUM(ABS(amount) * CASE WHEN transaction_type = 'withdrawal' THEN -1 ELSE 1 END), 0) AS net_difference
FROM
    Transactions
GROUP BY
    account_id;








-- 10. Write a SQL query to Calculate the average daily balance for each account over a specified 
-- period.
set @start_date='null';
set@end_date='null';
SELECT
    a.account_id,
    AVG(a.balance) AS average_daily_balance
FROM
    Accounts a
JOIN
    Transactions t ON a.account_id = t.account_id
WHERE
    t.transaction_date BETWEEN '@start_date' AND '@end_date' -- Replace with your specified period
GROUP BY
    a.account_id;


-- 11. Calculate the total balance for each account type.
SELECT
    account_type,
    SUM(balance) AS total_balance
FROM
    Accounts
GROUP BY
    account_type;
    -- 12
    SELECT
    a.account_id,
    COUNT(t.transaction_id) AS transaction_count
FROM
    Accounts a
JOIN
    Transactions t ON a.account_id = t.account_id
GROUP BY
    a.account_id
ORDER BY
    transaction_count DESC;
-- Q.13. List customers with high aggregate account balances, along with their account types.
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    a.account_type,
    SUM(a.balance) AS aggregate_balance
FROM
    Customers c
JOIN
    Accounts a ON c.customer_id = a.customer_id
GROUP BY
    c.customer_id, c.first_name, c.last_name, a.account_type
ORDER BY
    aggregate_balance DESC;

-- Q14. Identify and list duplicate transactions based on transaction amount, date, and account.


SELECT
    account_id,
    transaction_type,
    amount,
    transaction_date,
    COUNT(*) AS duplicate_count
FROM
    Transactions
GROUP BY
    account_id, transaction_type, amount, transaction_date
HAVING
    COUNT(*) > 1;
    
    
    
    
    
select * from customers;
select * from accounts;
select * from transactions;
-- Tasks 5: Subquery:
-- Q.1. Retrieve the customer(s) with the highest account balance.

select concat(first_name,' ',last_name) as full_name from customers c 
join accounts a on c.customer_id=a.customer_id where 
a.balance=(select max(balance) from accounts);

-- another way to acheive this 
-- select customer_id from accounts  where balance =(select max(balance ) from accounts);
-- 2. Calculate the average account balance for customers who have more than one account
SELECT 
    AVG(balance) AS average_balance,customer_id
FROM
    Accounts
WHERE
    customer_id IN (
        SELECT
            customer_id
        FROM
            Accounts
        GROUP BY
            customer_id
        HAVING
            COUNT(account_id) > 1
    ) group by customer_id;

    
    -- Q.3. Retrieve accounts with transactions whose amounts exceed the average transaction amount.
    SELECT
    a.account_id,
    a.account_type,
    t.transaction_id,
    t.transaction_type,
    t.amount,
    t.transaction_date
FROM
    Accounts a
JOIN
    Transactions t ON a.account_id = t.account_id
WHERE
    t.amount > (
        SELECT
            AVG(amount)
        FROM
            Transactions
    );


select * from customers;
select * from accounts;
select * from transactions;


    -- Q.4 Identify customers who have no recorded transactions. 
    
SELECT
    c.customer_id,
    c.first_name,
    c.last_name
FROM
    Customers c
WHERE
    customer_id  IN (SELECT
    c.customer_id
FROM
    Customers c
LEFT JOIN
    Accounts a ON c.customer_id = a.customer_id
LEFT JOIN
    Transactions t ON a.account_id = t.account_id
WHERE
    t.account_id IS NULL);
    

select sum(balance) from accounts a where not exists(select * from transactions where t.account_id=a.account_id);

-- Q.5. Calculate the total balance of accounts with no recorded transactions.
select sum(balance) ,customer_id from accounts
 where customer_id in (select  c.customer_id 
 from customers c left join accounts a on c.customer_id=a.customer_id
left join transactions t on a.account_id=t.account_id 
where transaction_id is null) group by customer_id ;
select min(balance) from accounts;
-- another way to achive

select sum(balance),c.customer_id, c.first_name, c.last_name
from Customers c
left join Accounts a on c.customer_id = a.customer_id

left join Transactions t on a.account_id = t.account_id

where t.transaction_id is null

group by c.customer_id, c.first_name, c.last_name;


-- rough
select customer_id, first_name, last_name from Customers c
where not exists  (select 1  from Transactions t  join Accounts a on t.account_id = a.account_id
                   where a.customer_id = c.customer_id);

-- select sum(balance) as total_balance from accounts a where not exists ( select * from transactions t where t.account_id = a.account_id);
-- Q.6. Retrieve transactions for accounts with the lowest balance.
 select balance from accounts where balance=(select min(balance) from accounts);

-- Q.7 Identify customers who have accounts of multiple types.
SELECT
    customer_id,
    first_name,
    last_name
FROM
    Customers
WHERE
    customer_id IN (
        SELECT
            customer_id
        FROM
            Accounts
        GROUP BY
            customer_id
        HAVING
            COUNT(DISTINCT account_type) > 1
    );
    

-- Q.8. Calculate the percentage of each account type out of the total number of accounts.
SELECT
    account_type,
    COUNT(*) AS account_count,
    (COUNT(*) / total_accounts.total_count) * 100 AS percentage
FROM
    Accounts,
    (SELECT COUNT(*) AS total_count FROM Accounts) AS total_accounts
GROUP BY
    account_type, total_accounts.total_count;
    
    
    
 -- rough
select sum(a.balance), c.customer_id, first_name, last_name from Customers c join accounts a on c.customer_id = a.account_id where not exists  

(select 1  from Transactions t  join Accounts a on t.account_id = a.account_id where a.customer_id = c.customer_id) group by customer_id,first_name,last_name;



-- Q.9. Retrieve all transactions for a customer with a given customer_id.
set @customer_id='5';
SELECT t.transaction_id, t.amount, t.transaction_date, c.first_name
FROM transactions t
JOIN accounts a ON a.account_id = t.account_id
JOIN customers c ON c.customer_id = a.customer_id
WHERE c.customer_id IN (SELECT customer_id FROM customers WHERE customer_id = @customer_id)
LIMIT 0, 1000;



-- 10. Calculate the total balance for each account type, including a subquery within the SELECT clause.
SELECT
    account_type,
    (SELECT SUM(balance) FROM Accounts a 
    WHERE a.account_type = outer_alias.account_type) 
    AS total_balance
FROM
    Accounts outer_alias
GROUP BY
    account_type;
    -- another way to do 
    SELECT
    account_type,
    SUM(balance) AS total_balance
FROM
    Accounts
GROUP BY
    account_type;

    

    
