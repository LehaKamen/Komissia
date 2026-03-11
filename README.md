# Komissia Android App

## VariantCode
HNALG-FRONT-MOD_D18_RETRY_POLICY

## Stack
- Kotlin
- Jetpack Compose
- Coroutines
- Retrofit
- Hilt (DI)

## API
Hacker News Search API (Algolia)

Base URL:
https://hn.algolia.com/api/v1

## Endpoints used

List (front page):
/search?tags=front_page

Detail:
/items/{id}

## Modifier

MOD_D18_RETRY_POLICY

При сетевой ошибке реализована политика повторных запросов:

1. Один автоматический повтор запроса через delay
2. Если ошибка остаётся — пользователю показывается кнопка "Retry"

## Features

- Story list (front page)
- Story detail screen
- Navigation between screens
- Loading / Content / Error states
- Retry button for network errors

## Screenshots

### Story List

![List](screenshots/list.png)

### Story Detail

![Detail](screenshots/detail.png)
