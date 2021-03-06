#!/usr/bin/env bash



# sudo -u postgres psql postgres
# postgres=# \password postgres



#Begin automatic creation of role
DB_USERNAME="postgres"
DB_PASSWORD="peter"
DB_HOST="localhost"

export PGUSER=$DB_USERNAME
export PGHOST=$DB_HOST
export PGPASSWORD=$DB_PASSWORD

echo "Creating new role..."

#If a user has not been created, uncomment the line below
psql -c "CREATE USER quickquery WITH PASSWORD 'qq@future' CREATEDB" 
psql -c "ALTER ROLE quickquery WITH CREATEDB"  
 

echo "Finished creating new role."
#End automatic creation of role

# Initialize the following variables as appropriate:
DB_USERNAME="quickquery"
DB_PASSWORD="qq@future"    
DB_HOST="localhost"

# There should be no need to change anything below this line.
echo "Starting database initialization script..."

export PGUSER=$DB_USERNAME
export PGHOST=$DB_HOST
export PGPASSWORD=$DB_PASSWORD

# Copy data to be imported into the Linux temporary folder
cp -fr ../data/* /tmp 

psql -f ../psql.tables.sql -d postgres 

echo "Have finished initializing database."


