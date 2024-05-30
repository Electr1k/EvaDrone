package ru.trifonov.evadrone.repository

import android.annotation.SuppressLint

import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motor

@SuppressLint("StaticFieldLeak")
object TestObject {


    val components = listOf(
        AirScrew(id = 0, title = "Винт АФП-324", description = "писание для винта пыпрпра", avgPrice = 139, weight = 0.1f, length = 20f/100),
        AirScrew(id = 1, title = "Винт Abo", description = "Описание для винта пыпрпра", avgPrice = 99, weight = 0.15f, length = 25f/100),
        AirScrew(id = 2, title = "Винт Mavic 3", description = "Винт с улучшенной конструкцией и усиленной прочностью", avgPrice = 165, weight = 0.125f, length = 23f/100),
        AirScrew(id = 3, title = "9453F", description = "Оптимизированный для повышенной нагрузки и улучшенной энергоэффективности", avgPrice = 115, weight = 0.135f, length = 27f/100),
        AirScrew(id = 4, title = "Винт Mavic Air", description = "Легкий и прочный винт для легкой авиации с улучшенными аэродинамическими свойствами", avgPrice = 175, weight = 0.11f, length = 24f/100),
        AirScrew(id = 5, title = "Винт Mavic Air 2", description = "Высокопроизводительный винт для промышленных применений с увеличенной долговечностью", avgPrice = 130, weight = 0.145f, length = 28f/100),
        AirScrew(id = 6, title = "Винт Mavic Air 2L", description = "Винт с увеличенной долговечностью и улучшенной устойчивостью к коррозии", avgPrice = 155, weight = 0.12f, length = 22f/100),
        AirScrew(id = 7, title = "Винт DJL Mini 2", description = "Экономичный винт для длительного использования с оптимизированным весом", avgPrice = 125, weight = 0.14f, length = 26f/100),
        AirScrew(id = 8, title = "Винт Cinelifter", description = "Винт с улучшенным качеством материалов и повышенной прочностью", avgPrice = 170, weight = 0.13f, length = 25f/100),
        AirScrew(id = 9, title = "Винт Cinelifter Pro", description = "Винт для специализированных задач с улучшенной управляемостью", avgPrice = 120, weight = 0.15f, length = 29f/100),
        AirScrew(id = 10, title = "Винт Cinelifter -330K", description = "Винт с высокой степенью коррозии и улучшенной защитой от влаги", avgPrice = 160, weight = 0.12f, length = 21f/100),
        AirScrew(id = 11, title = "Винт Cinelifter 7L", description = "Винт для экстремальных условий эксплуатации с повышенной устойчивостью к ударам", avgPrice = 140, weight = 0.135f, length = 27f/100),
        Motor(id = 12, title = "Привод F37-43", description = "", avgPrice = 599, weight = 0.2f, needVolt = 4.4f, needAmper = 0.3f, speedCycle = 1600),
        Motor(id = 13, title = "Привод F31-4b", description = "", avgPrice = 399, weight = 0.3f, needVolt = 3.9f, needAmper = 0.8f, speedCycle = 2000),
        Motor(id = 14, title = "Привод F96", description = "", avgPrice = 456, weight = 0.25f, needVolt = 2f, needAmper = 0.6f, speedCycle = 2500),
        Motor(id = 15, title = "Привод F45-55", description = "Новый привод с улучшенной мощностью", avgPrice = 450, weight = 0.22f, needVolt = 3.5f, needAmper = 0.4f, speedCycle = 1700),
        Motor(id = 16, title = "Привод E88 Pro", description = "Оптимизированный для долговременной работы", avgPrice = 420, weight = 0.27f, needVolt = 4.2f, needAmper = 0.65f, speedCycle = 1900),
        Motor(id = 17, title = "Привод SURPASS HOBBY", description = "Высокопроизводительный двигатель", avgPrice = 470, weight = 0.23f, needVolt = 2.5f, needAmper = 0.55f, speedCycle = 2300),
        Motor(id = 18, title = "Привод A2212", description = "Экономичный вариант для длительного использования", avgPrice = 410, weight = 0.24f, needVolt = 3.7f, needAmper = 0.7f, speedCycle = 2100),
        Motor(id = 19, title = "Привод 1S", description = "Специализированный для промышленных применений", avgPrice = 480, weight = 0.26f, needVolt = 3f, needAmper = 0.75f, speedCycle = 2400),
        Motor(id = 20, title = "Привод F56-66", description = "Легкий и компактный двигатель", avgPrice = 440, weight = 0.21f, needVolt = 4f, needAmper = 0.45f, speedCycle = 1800),
        Motor(id = 21, title = "Привод 2S", description = "Высокоскоростной для быстрых процессов", avgPrice = 460, weight = 0.25f, needVolt = 2.8f, needAmper = 0.6f, speedCycle = 2600),
        Motor(id = 22, title = "Привод 1104", description = "Мощный двигатель для тяжелых задач", avgPrice = 475, weight = 0.28f, needVolt = 3.6f, needAmper = 0.85f, speedCycle = 2200),
        Motor(id = 23, title = "Привод 2S-3S", description = "Энергоэффективный для экономии энергии",
        avgPrice = 490, weight = 0.29f, needVolt = 3.3f, needAmper = 0.9f, speedCycle = 2300),
        Motor(id = 24, title = "Привод A9PRO", description = "Интеллектуальный двигатель с автоматическим регулированием", avgPrice = 465, weight = 0.27f, needVolt = 2.7f, needAmper = 0.65f, speedCycle = 2700),
        Body(id = 25, title = "Корпус титан", description = "", avgPrice = 1000, weight = 4f, material = "Титан", countAirScrews = 4),
        Body(id = 26, title = "Корпус титан", description = "", avgPrice = 1000, weight = 4f, material = "Титан", countAirScrews = 4),
        Body(id = 27, title = "Корпус Carbon Fiber", description = "Легкий и прочный корпус из углепластика", avgPrice = 850, weight = 3.2f, material = "Углепластик", countAirScrews = 3),
        Body(id = 28, title = "Корпус Wood Composite", description = "Натуральный вид и легкость дерева", avgPrice = 700, weight = 3.5f, material = "Дерево", countAirScrews = 4),
        Body(id = 29, title = "Корпус Paper Honeycomb", description = "Экономичный и экологически чистый вариант", avgPrice = 600, weight = 3.8f, material = "Кarton", countAirScrews = 5),
        Body(id = 30, title = "Корпус Aluminum Alloy", description = "Высокая прочность и устойчивость к коррозии", avgPrice = 900, weight = 3.6f, material = "Алюминий", countAirScrews = 4),
        Body(id = 31, title = "Корпус Magnesium Alloy", description = "Легкий и прочный магниевый сплав", avgPrice = 950, weight = 3.4f, material = "Магний", countAirScrews = 3),
        Body(id = 32, title = "Корпус Kevlar", description = "Высокая прочность и устойчивость к огню", avgPrice = 800, weight = 3.3f, material = "Кевлар", countAirScrews = 2),
        Body(id = 33, title = "Корпус Titanium", description = "Прочность и устойчивость к коррозии", avgPrice = 1050, weight = 4.1f, material = "Титан", countAirScrews = 4),
        Body(id = 34, title = "Корпус Fiberglass", description = "Легкий и гибкий корпус из стекловолокна", avgPrice = 750, weight = 3.7f, material = "Стекловолокно", countAirScrews = 3),
        Body(id = 35, title = "Корпус Plastic", description = "Бюджетный вариант с хорошей прочностью", avgPrice = 550, weight = 3.9f, material = "Пластик", countAirScrews = 4),
        Body(id = 36, title = "Корпус Steel", description = "Прочность и долговечность стали", avgPrice = 1000, weight = 4.2f, material = "Сталь", countAirScrews = 5),
        Accumulator(id = 37, title = "Аккумулятор ТГА-314", description = "", avgPrice = 1004, weight = 1.1f, voltOut = 12f, amperOut = 4f),
        Accumulator(id = 38, title = "Аккумулятор Л-15", description = "", avgPrice = 924, weight = 2.1f, voltOut = 24f, amperOut = 5f),
        Accumulator(id = 39, title = "Аккумулятор ТПыр-514", description = "", avgPrice = 673, weight = 1.6f, voltOut = 18f, amperOut = 7.5f),
        Accumulator(id = 40, title = "Аккумулятор PowerPack Pro", description = "Высококапацитная батарея для долгого полета", avgPrice = 850, weight = 1.8f, voltOut = 14.8f, amperOut = 5.5f),
        Accumulator(id = 41, title = "Аккумулятор FlightMax", description = "Батарея с высокой емкостью для интенсивного использования", avgPrice = 750, weight = 2.2f, voltOut = 11.1f, amperOut = 4.2f),
        Accumulator(id = 42, title = "Аккумулятор EVO PowerCell", description = "Оптимизированная для быстрого зарядки и длительного использования", avgPrice = 600, weight = 1.5f, voltOut = 17.4f, amperOut = 3.7f),
        Accumulator(id = 43, title = "Аккумулятор SkyLion Ultra", description = "Высокопроизводительная батарея для профессионалов", avgPrice = 1200, weight = 2.4f, voltOut = 15.2f, amperOut = 6f),
        Accumulator(id = 44, title = "Аккумулятор ThunderPower Elite", description = "Батарея с улучшенной энергоэффективностью", avgPrice = 900, weight = 1.9f, voltOut = 13.4f, amperOut = 4.8f),
        Accumulator(id = 45, title = "Аккумулятор EagleEye Pro", description = "Идеально подходит для камероплетен", avgPrice = 700, weight = 1.3f, voltOut = 16.5f, amperOut = 3.3f),
        Accumulator(id = 46, title = "Аккумулятор Titan PowerPlus", description = "Предназначена для тяжелых нагрузок", avgPrice = 1300, weight = 2.7f, voltOut = 19.6f, amperOut = 5.1f),
        Accumulator(id = 47, title = "Аккумулятор Velocity Charge", description =
        "Быстрая зарядка и высокая производительность", avgPrice = 800, weight = 1.6f, voltOut = 20f, amperOut = 4f),
        Accumulator(id = 48, title = "Аккумулятор PhantomCore", description = "Оптимизирована для максимальной автономности", avgPrice = 1050, weight = 2f, voltOut = 21f, amperOut = 5f),
        Accumulator(id = 49, title = "Аккумулятор Quantum PowerBoost", description = "Высокая энергетическая плотность для быстрых маневров", avgPrice = 950, weight = 1.95f, voltOut = 23f, amperOut = 4.1f),
        Attribute(id = 50, title = "Камера GO PRO 1", description = "", avgPrice = 9999, weight = 1.3f),
        Attribute(id = 51, title = "Камера GO PRO 2", description = "", avgPrice = 12000, weight = 1f),
        Attribute(id = 52, title = "Гирокомпас для дронов", description = "Используется для определения направления", avgPrice = 450, weight = 0.2f),
        Attribute(id = 53, title = "Камера GoPro Hero 8", description = "Высококачественная камера для воздушных съемок", avgPrice = 300, weight = 0.3f),
        Attribute(id = 54, title = "Батарея LiPo 4S", description = "Батарея с высокой емкостью для длительной работы", avgPrice = 85, weight = 0.45f),
        Attribute(id = 55, title = "Радар для обнаружения препятствий", description = "Помогает избегать столкновений с препятствиями", avgPrice = 600, weight = 0.35f),
        Attribute(id = 56, title = "Система автономного полета", description = "Автоматизирует процесс полета и возвращения на базу", avgPrice = 700, weight = 0.25f),
        Attribute(id = 57, title = "Инфракрасная камера ночного видения", description = "Позволяет летать ночью без ограничений", avgPrice = 400, weight = 0.4f),
        Attribute(id = 58, title = "Солнечные панели для зарядки", description = "Предохраняют от исчерпания батареи в полете", avgPrice = 200, weight = 0.15f),
        Attribute(id = 59, title = "Сенсор ветра и скорости", description = "Помогает управлять дроном в сложных погодных условиях", avgPrice = 550, weight = 0.3f),
        Attribute(id = 60, title = "Микроволновый радар для обнаружения препятствий", description = "Более точное обнаружение препятствий на больших расстояниях", avgPrice = 750, weight = 0.4f),
        Attribute(id = 61, title = "Система автоматического следования за объектами", description = "Автоматически следует за выбранным объектом", avgPrice = 800, weight = 0.35f)
    )
}