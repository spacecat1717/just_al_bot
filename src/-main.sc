require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Пожауйста, напишите ваш вопрос
    
    state: App
        intent!: /пароль от приложения
        
    state: Card
        intent!: /пин от карты
        
    state: NoMatch
        event!: noMatch
        intent!: /начало