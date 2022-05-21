<opis czym jest keycloak i okta>

## Konfiguracja
  
  W katalogu głównym aplikacji należy uruchomić
> `docker-compose up -d`
  
  
  <img width="384" alt="image" src="https://user-images.githubusercontent.com/25098043/169653365-c9f3ebd8-d112-4e09-ac36-9b9d8797e8b2.png">

  Po adressem `localhost:5433` powinna powstać baza danych PostreSQL. Nazwa bazy danych to ask_db. 
  > User: `ask_db_user` hasło: `ask_db_password`
  
  Pod adressem `localhost:28080` powinien pojawić Keycloak dashboard.
  
  ![MicrosoftTeams-image](https://user-images.githubusercontent.com/25098043/169652995-9a3f2fd2-9a5b-4f2d-a3f8-8044f5c231ff.png)

  Po kliknięciu na 'Administration Console' możemy zalogować się za pomocą danych
>  user: `admin`, hasło: `admin`

  Następnie klikamy import, i wybieamy plik `ask/imports/realm-export.json`. Po zaimportowaniu tego pliku został stworzony realm pod nazwą _ASK_.
  
  W tym realmie jest dodany client który nazywa się "spring-boot-keycloak". Także automatycznie zostaje dodany identity provider __Okta__ pod nazwą "oktaidc". Należy wejść w jego konfigurację i wpisać Client ID oraz Client Secret aplikacji Okta. 
  
  Jest też skonfigurowany First Login Flow, który automatycznie dodaje nowego użytkownika autoryzowanego przez Oktę do bazy danych.
  
## Dodawanie użytkownika

  Warto dodać przykładowego użytkownika w zakładce __Users__ za pomocą przycisku Add user. Należy dodać mu Username, a po zapisaniu użytkownika w zakładce Credentials przypisać mu hasło. Ten użytkownik automatycznie musi skorzystać z OTP, co widać na obrazku poniżej.
  
  <img width="1063" alt="image" src="https://user-images.githubusercontent.com/25098043/169653522-e72413d5-7efd-49f9-b829-b3d2a7d68f2f.png">

Przed uruchomieniem aplikacji należy dodać dwie wartości do zmiennych środowiskowych. Są to wartości dla Weather API.
  
![MicrosoftTeams-image (1)](https://user-images.githubusercontent.com/25098043/169653681-5e0feb8a-2496-4606-bbd7-c77f9abd7312.png)
  
Po uruchomieniu na porcie localhost:8080 będzie działać następująca aplikacja:
  
  ![MicrosoftTeams-image (2)](https://user-images.githubusercontent.com/25098043/169653764-3ce9526a-ac32-485d-83c3-49eec4245ec7.png)

  Po kliknięciu Login widzimy okno logowania / autoryzacji. Możemy zalogować się za pomocą Keycloak oraz Okta.
  
  > Po zalogowaniu po raz pierwszy za pomocą tych danych, należy dodać narzędzie 2FA, takie jak Google Authenticator.

  ![MicrosoftTeams-image (3)](https://user-images.githubusercontent.com/25098043/169653904-c85c884e-4569-4257-a8d4-abad373f93d6.png)
  
  Po zalogowaniu widzimy stronę z aktualną informacją pogodową dla trzech miast: Krakowa, Gdańska i Warszawy.

  ![MicrosoftTeams-image (4)](https://user-images.githubusercontent.com/25098043/169653979-d4d8a089-7dec-4666-951b-07f69764d2a0.png)

Użytkownik jest zalogowany i widzi stronę aplikacji.

  
