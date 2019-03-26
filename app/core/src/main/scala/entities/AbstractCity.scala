package entities

class AbstractCity(
    id: Int,
    name: String,
    cityCode: String,
    prefecture: String,
    population: Int,
    geom: Any
){
  val prefNum: String = cityCode.slice(0, 2)
}
