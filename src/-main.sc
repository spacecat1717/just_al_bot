require: slotfilling/slotFilling.sc
  module = sys.zb-common

patterns:
    $One = (1)
    $Two = (2)  

theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Пожалуйста, напишите ваш вопрос
    
    state: App
        intent!: /пароль от приложения
        a: Смена пароля от приложения возможна несколькими способами:
            1. на экране "Профиль"  выберите Изменить код входа в приложение
            2. введите SMS-код. 3. придумайте новый код для входа в приложение и повторите его.
            Либо нажмите на кнопку "Выйти" на странице ввода пароля для входа в приложение. После чего нужно будет заново пройти регистрацию:
            1. ввести полный номер карты (если оформляли ранее, иначе номер телефона и дату рождения)
            2. указать код из смс
            3. придумать новый пароль для входа.
        go!: /Finish
        
        
    state: Card
        intent!: /пин от карты
        a: Это можно сделать в приложении:
            1. На экране «Мои деньги» в разделе «Карты» нажмите на нужную.
            2. Выберите вкладку «Настройки».
            3. Нажмите «Сменить PIN-код».
            4. Введите удобную вам комбинацию.
            5. Повторите ее.
            И все готово!
            PIN-код установлен, можно пользоваться. 
        go!: /Finish
            
        
    state: NoMatch
        event!: noMatch
        intent!: /начало
        a:  Здравствуйте!
            Сейчас расскажу порядок действий.
            Выберите, что именно планируете сделать:
            1. Поменять пароль для входа в приложение.
            2. Поменять PIN-код от карты.

            Пожалуйста, отправьте цифру, соответствующую вашему выбору.
        
            
        state: ChoiceOne
            q: * $One * 
            go!: /App
        
        state: ChoiceTwo
            q: * $Two *
            go!: /Card
        
    state: Finish
        a: Приятно было пообщаться. Всегда готов помочь вам снова 