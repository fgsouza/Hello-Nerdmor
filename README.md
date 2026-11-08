# Hello Nerdmor — APK Android

App Android "Hello World" do **[nerdmor.com](https://nerdmor.com)**, em estilo nerd/terminal:
fundo escuro, logo `<NERDMOR/>` em verde neon, um prompt com cursor piscando e um botão que abre o site.

- Java puro, sem dependências externas (só o SDK Android)
- `minSdk 26` (Android 8.0+), `targetSdk 35`
- Ícone adaptativo em vetor (`</>`)

## Obter o APK

### GitLab
1. Crie um projeto no GitLab e envie este repositório:
   ```bash
   git remote add gitlab git@gitlab.com:<seu-usuario>/hello-nerdmor.git
   git push gitlab --all
   ```
2. O pipeline (`.gitlab-ci.yml`) roda sozinho e gera `nerdmor-hello-world.apk`.
3. Baixe em **Build → Pipelines → assembleDebug → Artifacts**.

### GitHub
O workflow `.github/workflows/android.yml` gera o mesmo APK. Baixe na aba **Actions** → execução mais recente → artefato `nerdmor-hello-world`.

### Local
Com o Android SDK instalado (`ANDROID_HOME` definido ou `local.properties` com `sdk.dir=...`):
```bash
./gradlew assembleDebug
# APK em app/build/outputs/apk/debug/app-debug.apk
```

## Instalar no celular
Copie o APK para o aparelho e abra-o (permita "instalar apps de fontes desconhecidas"), ou:
```bash
adb install nerdmor-hello-world.apk
```

## Personalizar o estilo
- Cores: `app/src/main/res/values/colors.xml`
- Textos: `app/src/main/res/values/strings.xml`
- Layout: `app/src/main/res/layout/activity_main.xml`
- Ícone: `app/src/main/res/drawable/ic_launcher_foreground.xml`
