# InvestoReady

An Android application that will display top 15 stocks (Selected by a stock market expert) and their analyzed data (P/B Ratio , P/E Ratio , Return on Equity , Dividend Yield , Debt to Equity and Net Profit Margin and Stock Prices from year 2006 to 2022). This application is mainly for beginners. The application also provides the user to automatically generate a portfolio and also provides a Return of Investment Calculator (ROI) for 2 stocks (as of 08/12/2022) namely TCS and Infosys

## Table of Contents

- [ Motivation ](#motivation)
- [ Screenshots ](#screenshots)
- [ Technology/Framework Used ](#technology)
- [ Algorithms ](#algorithms)
- [ Features ](#features)
- [ Code Examples ](#codeExamples)
- [ Installation ](#installation)
- [ How To Use ? ](#howToUse)
- [ API Reference ](#apireference)
- [ Credits ](#credits)
- [ License ](#license)

### Team

- [@Pratham-cymk](https://www.github.com/Pratham-cymk): Backend & Logic of App
- [@ram7203](https://github.com/ram7203): Frontend
- [@puneetmpatil](https://github.com/puneetmpatil): Backend & Logic of App

<a name = "motivation"></a>

## <ins>Motivation</ins>

In recent times, investing is as important as earning. Financial literacy can allow a person to reach different level of heights. Investing is considered to be a risky task (particularly in stocks) because of which many people avoid it. Hence to make investing easy we are proposing this idea.

<a name="screenshots"></a>
<!-- Screenshots to be added -->

### <ins>Screenshots</ins>
<img src="screenshots/Welcome.png" height="300" alt="Welcome Page" />
<img src="screenshots/SignUp.png" height="300" alt="Sign Up Page" />
<img src="screenshots/Login.png" height="300" alt="Login Page" />
<img src="screenshots/StockList1.png" height="300" alt="StockList Page" />
<img src="screenshots/StockList2.png" height="300" alt="StockList Page" />
<img src="screenshots/StockList3.png" height="300" alt="StockList Page" />
<img src="screenshots/Reliance1.png" height="300" alt="Reliance Page" />
<img src="screenshots/Reliance2.png" height="300" alt="Reliance Page" />
<img src="screenshots/TCS1.png" height="300" alt="TCS Page" />
<img src="screenshots/TCS2.png" height="300" alt="TCS Page" />
<img src="screenshots/Portfolio1.png" height="300" alt=Portfolio Page" />
<img src="screenshots/Portfolio2.png" height="300" alt=Portfolio Page" />
<img src="screenshots/Portfolio3.png" height="300" alt=Portfolio Page" />
<img src="screenshots/ROICalculator1.png" height="300" alt="ROI Calculator Page" />
<img src="screenshots/Account.png" height="300" alt="Account Page" />

<a name="technology"></a>

### <ins>Tech/ Framework used</ins>

<ins>IDES</ins>
<br>

<a href="https://developer.android.com/studio?gclid=EAIaIQobChMI-YHVttfW-wIVC5JmAh0shAucEAAYASAAEgJW8PD_BwE&gclsrc=aw.ds" target="_blank"><img src="https://img.icons8.com/fluency/48/null/android-studio--v2.png" alt="Android studio" width="40" height="40"><a href="https://code.visualstudio.com/" target="_blank"><img src="https://img.icons8.com/color/48/null/visual-studio-code-2019.png" alt="Visual Studio Code" width="40" height="40"><a href="https://jupyter.org/" target="_blank"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Google_Colaboratory_SVG_Logo.svg/1200px-Google_Colaboratory_SVG_Logo.svg.png?20221103151432" alt="Google Colab" width="40" height="40">

<ins>Programming Languages</ins>
<br>
<a href="https://www.python.org/" target="_blank"><img src="https://img.icons8.com/color/48/null/python--v1.png" alt="Python" width="40" height="40"><a href="https://www.java.com/en/" target="_blank"><img src="https://img.icons8.com/fluency/48/null/java-coffee-cup-logo.png" alt="Java" width="40" height="40"></a><a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank"><img src="https://img.icons8.com/color/48/null/javascript--v1.png" alt="Javascript" width="40" height="40"></a>

<ins>Database</ins>
<br>
<a href="https://firebase.google.com/" target="_blank"><img src="https://img.icons8.com/color/48/null/firebase.png" alt="Firebase" width="40" height="40"></a>

<ins>Libraries</ins>
<br>
<a href="https://www.alphavantage.co/" target="_blank"><img src="images/alphavantage.png" alt="Alpha Vantage" width="40" height="40"></a>
<a href="https://pandas.pydata.org/" target="_blank"><img src="https://img.icons8.com/color/48/null/pandas.png" alt="Pandas" width="40" height="40"></a>
<a href="https://reactjs.org/" target="_blank"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="React JS" width="40" height="40"></a>

<a name="algorithms"></a>

### <ins> Algorithms </a>

- [ ROI Calculator Algorithm ](#ROICalculator)
- [ Portfolio Generation Algorithm ](#portfolio)

<a name="ROICalculator"></a>
<ins>**ROI Calculator Algorithm**</ins>

**Given :**

1. Bonus year array
2. Bonus year ratio factor array
3. Dividend factor
4. Price of stock with year varying from current year to base year

**Input :**

- Investment

**Output :**

- Total dividend received over no of years (current year - base year)
- Current evaluation

**Algorithm:**

<ol>
<li> Input amount to be invested from user</li>
<li> Let base year for calculation be 2006</li>
<li> Define an array which will store the bonus year of each stock and another array for bonus year ratio factor.
For example: TCS has offered 1:1 ratio of stocks in the years 2006, 2009 and 2018. It means that the quantity of stocks doubled in those years. </li>
<li> Define an array price which will contain prices from 2006 (base year) to 2022 (current year) in decreasing order of year</li>
<li>Define dividend factor of the stock</li>
<li>If the base year = 2006 and the current year = 2022, no of years = 17. Therefore number of financial years = 16</li>
<li>Find initial quantity of stocks</li>

**quantity = investment_amount/price(2006)**
<li>Initialize total dividend to zero</li>
<li>
for i := (no of years - 2) to 0 and year := (2006)
<ul>
<li>If year is a bonus year then multiply quantity of stocks by bonus_year_factor_ratio for that year</li>
<li>total_dividendent =  total_dividendent + quantity*((price[i]*dividendFactor)/100)</li>
<li>Increment value of year</li>
<li>Decrement value of i</li>
</ul>
<li>Output current evaluation and total dividend received

**current_valuation = (current_stock_price * quantity_of_stocks)**

</li>
</ol>

<a name="portfolio"></a>
<ins>**Portfolio Generation Algorithm**</ins>

**Input :**
Budget / Investment amount

**Output :**

1. Total allocated amount
2. Sector-wise allocated amount
3. Quantity of stock sector-wise
4. Total remaining amount

**Algorithm:**
<ol>
<li>Input budget or amount to be invested from user (Minimum investment = 30000)</li>
<li>We assume the no. of sectors from which stocks will be allocated belong to be 6 and we select the top 3 best stocks from many stocks based on research by a team of experts.</li>
<li>Find the sector-wise amount to be allotted

**sectoralAmount = budget / noOfSectors**
</li> 
<li>We have the top 3 companies per sector wise along with their current prices with us</li>
<li>for i = 1 to noOfSectors 
<ol>
<li>Select a stock from each sector and find the quantity</li>
<li>

**quantity = sectoralAmount/(price_of_stock_randomly_selected)**
</li> 
<li>

**remainingAmountPerSector = sectoralAmount%(price_of_stock_randomly_selected)**
</li>
<li>

**totalAllocated = totalAllocated + (quantity * (price_of_stock_randomly_selected))**
</li>
</ol></li>
<li>

**totalRemaining = budget - totalAllocated**
</li>
<li>From each sector we find the stock with minimum price and that minimum price should be less than remaining amount</li>
<li>If no stock can be found which has price less than remaining amount then your portfolio has been generated</li>
<li>Else u find the additional quantity of stocks which can be bought using the remaining amount</li>
<li>Find total allocated amount and total remaining amount</li>
<li> Output the total allocated amount, sector-wise allocated amount, quantity of stock sector-wise and total remaining amount</li>
</ol>
<a name="features"></a>

### <ins>Features</ins>

<ol>
    <li>AI powered portfolio</li>
    <li>Return of Investment Calculator (ROI)</li>
</ol>

<!-- Code Examples -->
<a name="codeExamples"></a>

### <ins>Code Examples</ins>

<!-- Installation -->
<a name="installation"></a>

### <ins>Installation</ins>

<a name="apireference"></a>

## <ins>API Reference</ins>

<a href="https://www.alphavantage.co/documentation/" target="_blank">Alpha Vantage</a>

<!-- How To Use ? -->
<a name="howToUse"></a>

### <ins>How to use?</ins>

<!-- Credits -->
<a name="credits"></a>

### <ins>Credits</ins>

- [Insert Data from Firebase using Python](https://youtu.be/DCaH4bQ4DxA)
- [Retrieve Data from Firebase using Android](https://www.geeksforgeeks.org/how-to-retrieve-data-from-the-firebase-realtime-database-in-android/)

<a name="license"></a>

###### <ins>License</ins>

<a href="/LICENSE">MIT License</a>
