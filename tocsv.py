import pandas as pd
import mysql.connector
import pymysql

# MySQL database connection details
host = 'localhost'
user = 'fahrialmd'
password = '7'
database = 'herb'

# Establish a connection to the MySQL server using pymysql
connection = pymysql.connect(host=host, user=user, password=password, database=database)


# Path and filename for the output CSV file
output_file = 'file.csv'
\

# Create a cursor object to execute SQL queries
cursor = connection.cursor()

# SQL query to select all rows from the tabel_artikel table
query = 'SELECT * FROM tabel_artikel'

# Execute the query
cursor.execute(query)

# Fetch all rows from the result
rows = cursor.fetchall()

# Get the column names from the cursor description
column_names = [column[0] for column in cursor.description]

# Create a pandas DataFrame from the fetched rows and column names
df = pd.DataFrame(rows, columns=column_names)

# Write the DataFrame to a CSV file
df.to_csv(output_file, index=False)

# Close the cursor and connection
cursor.close()
connection.close()

print(f"Table data exported to '{output_file}' successfully.")
