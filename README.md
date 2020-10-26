# Background

See [Oricon's Wikipedia page](https://en.wikipedia.org/wiki/Oricon) and
[Oricon Ranking page (Japanese)](http://www.oricon.co.jp/rank/).

In short, Oricon is an organisation that provides statistics and
information regarding sales ranking of several entertainment mediums
in Japan.

# Description

This user story lets a Line user to know the top 10 Blu-ray
sales in Japan according to Oricon chart at a given date.

# Webservice API

- N/A
- You have to use [screen scraping](https://en.wikipedia.org/wiki/Data_scraping#Screen_scraping)
technique to extract data from Oricon Web pages
    - Hint: You can browse yearly/monthly/weekly/daily charts from menu
    item containing string **Blu-ray総合** in Oricon Ranking page

# Input Specs

- `/oricon bluray weekly YYYY-MM-DD`
    - `weekly` string is a flag to return weekly top 10 chart
    at given date
    - **YYYY** is a year, e.g. 2017, 2016
    - **MM** is a month, e.g 01 is January, 02 is February, 12 is
    December
    - **DD** is a day, e.g. `2017-05-09` means 9 May 2017
- `/oricon bluray daily YYYY-MM-DD`
    - `daily` string is a flag to return daily top 10 chart at
    given date

# Output Specs

- A 10-lines string where each string is formatted as follows:
`(CHART POSITION) BLURAY TITLE - ARTIST - RELEASE DATE`
    - Example:

    ```
    (1) 超ネバギバDANCE - 超特急 - 2017-04-27
    (2) ヒトリゴト - ClariS - 2017-04-26
    (3) I Dunno - Lazy Town - 2001-01-01
    ...
    (10) Sogno di Volare (Civilization VI Main Theme) - Christopher Tin - 2016-12-01
    ```
- Provide error messages if:
    - There is no top 10 chart information at a given date (**YEAR**/**MONTH**/**DAY**)
    - Impossible dates were given (e.g. 2017-02-31, 2017-11-31)
- Ensure that you follow **[defensive programming](https://en.wikipedia.org/wiki/Defensive_programming)**
and please make the error messages as helpful as possible!

# Definition of Done

- [X] WIP contained in a branch and tracked in GitLab repository
- [X] Created or worked a module specific for containing functionalities related to this user story
- [X] Wrote stubs & unit tests
- [X] Test coverage >= 70%
- [X] Provided error handling for boundary cases and other exceptional cases
- [X] Build passed (i.e. not failed)
- [X] Have tested the working build on Heroku instance

Related Branch 

[Branch For This Story] (https://gitlab.com/csui-advprog-2018/A/A3/tree/story-top10-oricon-bd)

[Merge Request for this Story] (https://gitlab.com/csui-advprog-2018/A/A3/merge_requests/35)

Line Bot : @nrl3146n

Issue for project: A3