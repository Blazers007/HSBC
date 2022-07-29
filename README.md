### Github App

#### Structure

- App Module (Shell)
- Feature Modules -> folder: layer_features 
  - Home: Integrated search & login
  - Search: Enter keywords to search repos
  - Profile: Receive username to show profile(Avatar / Nick etc.)
  - Login: !Not Complete! Github doesn't support simple username / password login
- Base Modules -> folder: layer_base
  - Common: Base Activity / Base Fragment
  - Constants: Values / Colors
  - Model: Sharing models
- Tools Modules -> folder: layer_tools
  - ImageLoader: support Picasso / Glide
  - Network: Using OKHTTP and expose Retrofit dependency

#### Screenshots

![LIST](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/list.png)
![SEARCHING](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/searching.png)
![SEARCH](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/search.png)
![PROFILE](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/profile.png)
![HOME](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/home.png)