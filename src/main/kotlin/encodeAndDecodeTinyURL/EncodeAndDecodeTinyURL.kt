package encodeAndDecodeTinyURL

class EncodeAndDecodeTinyURL {
    private val hashCodeToLongUrl = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val hashCode = longUrl.hashCode().toString()
        hashCodeToLongUrl[hashCode] = longUrl
        return hashCode
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return hashCodeToLongUrl[shortUrl]!!
    }

    fun cleanUp() = hashCodeToLongUrl.clear()

    fun numberOfKey() = hashCodeToLongUrl.keys.size
}
