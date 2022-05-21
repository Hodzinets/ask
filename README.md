<opis czym jest keycloak i okta>

## Konfiguracja
  
  W katalogu głównym aplikacji należy uruchomić
> `docker-compose up -d`
  
  
  <img width="384" alt="image" src="https://user-images.githubusercontent.com/25098043/169653365-c9f3ebd8-d112-4e09-ac36-9b9d8797e8b2.png">

  Po adressem `localhost:5433` powinna powstać baza danych PostreSQL. Nazwa bazy danych to ask_db. Credentiale - User: ask_db_user hasło: ask_db_password
  
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

