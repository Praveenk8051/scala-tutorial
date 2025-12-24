val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals("France")
capitals.get("Germany")
capitals.getOrElse("Germany", "Not Found")
val updated = capitals + ("Germany" -> "Berlin")
val newMap = capitals - "Japan"
for ((country, city) <- updated)
{
  println(s"Capital of $country is $city")
}