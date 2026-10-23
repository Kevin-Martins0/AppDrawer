# AppDrawer

Aplicativo Android nativo em Kotlin que demonstra um menu lateral de navegação (`DrawerLayout` + `NavigationView`).

## Recursos

- Menu lateral com as seções Início, Meu perfil e Configurações.
- Ícone de menu na barra superior para abrir o drawer.
- Atualização do título e do conteúdo conforme a seção selecionada.
- Ajuste de espaçamento para as barras do sistema e descrições acessíveis.

> **Estado atual:** Perfil e Configurações são telas demonstrativas. Cadastro, armazenamento de dados e preferências ainda não foram implementados.

## Requisitos

- Android Studio compatível com Android Gradle Plugin 9.0.1.
- JDK 21.
- Android SDK Platform 36.

## Abrir e executar

1. Extraia o projeto e abra a pasta `AppDrawer` no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Selecione um emulador ou conecte um dispositivo Android.
4. Execute a configuração `app`.

Para gerar o APK de depuração no terminal:

```bash
./gradlew assembleDebug
```

Para executar os testes unitários:

```bash
./gradlew testDebugUnitTest
```

O APK de depuração será gerado em `app/build/outputs/apk/debug/app-debug.apk`.
