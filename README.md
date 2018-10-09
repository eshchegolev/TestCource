# TestCource
## Работа с Git
Тут уже выбираем способ, с которым Вам будет предпочтительней работать HTTP или SSH. Для работы по HTTP протоколу скачивать и проворачивать нижеперечисленне действия не нужно, сразу переходите к клонированию репозитория.
SSH:
- Скачиваем дистрибутив Git - https://git-scm.com/downloads (в зависимотси от OS и архитектуры процессора (x32/x64) выбираем нужный файл)
1) ![http://screenshot.ru/c452729d00baf5de5caa688ce8c68a40.png](http://screenshot.ru/c452729d00baf5de5caa688ce8c68a40.png)
2) ![http://screenshot.ru/7d7f4301872b651136fd1753f60a5832.png](http://screenshot.ru/7d7f4301872b651136fd1753f60a5832.png)

Проблем возникнуть не должно, просто везде жмем Next. Ждем конца установки и следующим шагом запускаем из Проводника (ПКМ по папке/раб столу/месту...) Git Bash ->
 
 ![http://screenshot.ru/4e5ffda3f2c80120f7ecd9b7f74c40d9.png](http://screenshot.ru/4e5ffda3f2c80120f7ecd9b7f74c40d9.png)
или через Git Bash.lnk в папке с установленой программой:

![http://screenshot.ru/872cc288bb0f58827912977d89b53c17.png](http://screenshot.ru/872cc288bb0f58827912977d89b53c17.png)

Генерация SSH ключей для доступа на репозиторий:
В терминале вводим команду "ssh-keygen" (можете вникнуть в предлагаемые настройки ключа, можете пропустить - не столь важно)

Получаем что-то на подобии вот этого:
$ ssh-keygen 
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/schacon/.ssh/id_rsa): 
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /Users/user/.ssh/id_rsa.
Your public key has been saved in /Users/user/.ssh/id_rsa.pub

Идем в файл /Users/user/.ssh/id_rsa.pub и копируем куда-нибудь содержимое:
![http://screenshot.ru/bb366edf534e400838f01bc77913ab8e.png](http://screenshot.ru/bb366edf534e400838f01bc77913ab8e.png)

Далее переходим в уже зарегистрированный аккаунт GitHub -> Profile -> Settings -> SSH and GPG keys -> Add SSH new key
Вставляем содержимое файла id_rsa.pub, сохраняем.
![http://screenshot.ru/5741bf0570fbb3ba0031c8412e5ce557.png](http://screenshot.ru/5741bf0570fbb3ba0031c8412e5ce557.png)
![http://screenshot.ru/fa2f98b9929032607434e6667082e342.png](http://screenshot.ru/fa2f98b9929032607434e6667082e342.png)

### Клонирование репозитория в IDE
Для способа HTTP авторизации ->
![http://screenshot.ru/b8d975f0379f0c497ce80911f0ffefee.png](http://screenshot.ru/b8d975f0379f0c497ce80911f0ffefee.png)
Для SSH ->
![http://screenshot.ru/380574262e6fd39bef1f363e6bad5ab6.png](http://screenshot.ru/380574262e6fd39bef1f363e6bad5ab6.png)

Запускаем IDE до стартовой страницы -> Check out from Version Controll -> Git ->
![http://screenshot.ru/519ae427d5f46748ed88376cf1dad0d2.png](http://screenshot.ru/519ae427d5f46748ed88376cf1dad0d2.png)
Нажимаем Clone -> 
![http://screenshot.ru/8671df95dbabc1b9d1107e6380de06cc.png](http://screenshot.ru/8671df95dbabc1b9d1107e6380de06cc.png)
Yes -> либо импортируем проект в зависимости от утилит сборки либо создаем новый (планируется сборщик maven) -> Next - Next -> Next -> Finish

Убедительная просьба - пока что ничего не заливать!
