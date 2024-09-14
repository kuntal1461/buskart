DROP TABLE IF EXISTS bookings;

-- 2. Drop the users table if it exists
DROP TABLE IF EXISTS users;

-- 3. Create the users table with auto-incremented user_id
CREATE TABLE users (
    user_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,  -- Auto-incremented unique user ID
    name VARCHAR(255) NOT NULL,                                -- User's full name
    email VARCHAR(255) UNIQUE NOT NULL,                        -- User's email (must be unique)
    phone_number VARCHAR(20) UNIQUE,                           -- User's phone number (optional, must be unique)
    password VARCHAR(255) NOT NULL,                             -- Password (hashed)
    created_at TIMESTAMP DEFAULT NOW(),                         -- Timestamp when the user was created
    updated_at TIMESTAMP DEFAULT NOW()                          -- Timestamp for the last update
);

-- 4. Create the bookings table with user_id as BIGINT to match users.user_id
CREATE TABLE bookings (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,          -- Auto-incrementing ID
    booking_id VARCHAR(50) UNIQUE NOT NULL,                      -- Unique booking number
    user_id BIGINT NOT NULL,                                      -- ID of the user who made the booking (Foreign Key)
    customer_name VARCHAR(255) NOT NULL,                         -- Name of the customer
    booking_date DATE NOT NULL,                                   -- Date of booking
    status VARCHAR(50) NOT NULL,                                  -- Status (Confirmed, Cancelled, etc.)
    amount DECIMAL(10, 2),                                        -- Amount paid (DECIMAL for arithmetic operations)
    destination VARCHAR(255),                                     -- Destination of the booking
    source VARCHAR(255) NOT NULL,                                 -- Starting point of the booking (source)
    seat_number VARCHAR(10),                                      -- Seat number for the booking
    bus_type VARCHAR(50),                                         -- Type of bus (AC, Non-AC, etc.)
    field1 VARCHAR(255),                                          -- Extra field 1 for additional data
    field2 VARCHAR(255),                                          -- Extra field 2 for additional data
    field3 VARCHAR(255),                                          -- Extra field 3 for additional data
    created_at TIMESTAMP DEFAULT NOW(),                           -- Auto-created timestamp
    updated_at TIMESTAMP DEFAULT NOW(),                           -- Auto-updated timestamp
    FOREIGN KEY (user_id) REFERENCES users(user_id)               -- Foreign key to users table
);