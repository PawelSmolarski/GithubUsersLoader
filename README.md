# GithubUsersLoader

Application is simply crawler for first 30 users fetched from Github API and 3 first assigned repos. 

It works offline when there is problem with dowloading data from API and there was previously fetched data.

Github's API has limitations of number of possible sent requests. To omit this limitation there is possibility to provide own authentication token which gives possibility to exted the limit of API requests.
In the build.gradle file there is Config Field named "API_TOKEN". There is possibility to provide own authentication token.
E.g. 

buildConfigField "String", "API_TOKEN", "\"Bearer xyz\"", 
where xyz is ones token. Please pay attention for "Bearer" prefix.
