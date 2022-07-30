### Github App

![LIST](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/layer.png)


#### Structure

- App Module (Shell)
- Feature Modules -> folder: layer_features 
  - Home: Integrated search & login
  - Search: Enter keywords to search repos, auto record query history
  - Profile: Receive username to show profile(Avatar / Nick etc.)
  - Login: !Inomplete! Github doesn't support simple username / password login
- Base Modules -> folder: layer_base
  - Common: Base Activity / Base Fragment
  - Constants: Values / Colors
  - Model: Sharing models
- Tools Modules -> folder: layer_tools
  - ImageLoader: support Picasso / Glide
  - Network: Using OKHTTP and expose Retrofit dependency
  

#### Using Libs / Frameworks

- Jetpack
  - Room
  - ViewModel
  - Paging
  - Security
- Kotlin
  - Flow & Coroutine
- [OKHTTP](https://github.com/square/okhttp)
- [Retrofit](https://github.com/square/retrofit)
- [Moshi](https://github.com/square/moshi)
- [Picasso](https://github.com/square/picasso)
- [Glide](https://github.com/bumptech/glide)
- [RoundedImageView](https://github.com/vinc3m1/RoundedImageView)
- [Flexbox-Layout](https://github.com/google/flexbox-layout)

#### Screenshots

![LIST](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/list.png)
![SEARCHING](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/searching.png)
![SEARCH](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/search.png)
![PROFILE](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/profile.png)
![HOME](https://raw.githubusercontent.com/Blazers007/HSBC/master/pics/home.png)
