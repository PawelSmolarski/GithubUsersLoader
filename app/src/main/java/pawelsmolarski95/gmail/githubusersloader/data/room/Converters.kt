package pawelsmolarski95.gmail.githubusersloader.data.room

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    private val stringType = Types.newParameterizedType(List::class.java, String::class.java)
    private val stringsAdapter = Moshi.Builder().build().adapter<List<String>>(stringType)

    @TypeConverter
    fun fromList(values: List<String>) = stringsAdapter.toJson(values)

    @TypeConverter
    fun toList(value: String) = stringsAdapter.fromJson(value).orEmpty()
}
