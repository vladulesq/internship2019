    **Given a user situated in location A, and 4 ATMS such that:**
1. The walking time between starting point and ATMs as well as between each ATMs is presented below:
    
    | From                 | To           | Duration (minutes) |
    |----------------------|--------------|--------------------|
    | User starting point  | ATM 1        | 5                  |
    | User starting point  | ATM 2        | 60                 |
    | User starting point  | ATM 3        | 30                 |
    | User starting point  | ATM 4        | 45                 |
    | ATM 1                | ATM 2        | 40                 |
    | ATM 1                | ATM 4        | 45                 |
    | ATM 2                | ATM 3        | 15                 |
    | ATM 3                | ATM 1        | 40                 |
    | ATM 3                | ATM 4        | 15                 |
    | ATM 4                | ATM 2        | 30                 |
    
2. Each ATM has the same amount of money equal with 5000 lei, and the following schedule:

    | ATM Name | Opening time | Closing time |
    |----------|--------------|--------------|
    | ATM 1    | 12:00        | 18:00        |
    | ATM 2    | 10:00        | 17:00        |
    | ATM 3    | 22:00        | 12:00        |
    | ATM 4    | 17:00        | 01:00        |

3. User has 3 credit cards with the following properties:

    | Credit card | Fee  | Withdraw limit (lei) / day  | Expiration date| Available Amount (lei)|
    |-------------|------|-----------------------------|----------------|-----------------------|
    | SILVER      | 0.2% | 4500                        | 23.05.2020     | 20000                 |
    | GOLD        | 0.1% | 3000                        | 15.08.2018     | 25000                 |
    | PLATINUM    | 0%   | 4000                        | 20.03.2019     | 3000                  |

4. Current date and time is: *19th March, 2019 - 11:30*

**Please write an application using either Java or C# programming language in order to:**
1. <h5>Subject code = INT01 </h5>
 Determine what ATMs and in which order the user needs to access for withdrawing 7500 lei until 19th March, 2019 - 14:00, with smallest fee available,
using only valid credit cards (that are not expired at the current date),
without passing through the same location twice.
Processing time for each ATM is negligible.

The application should implement the following method:

    public List<Atm> getAtmsRoute() {
        // TODO: add your code here
    }


**Note:**

1. *All dates are in the same timezone.*
2. *Only specified constraints are to be taken in consideration.*
