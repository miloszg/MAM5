// Zmniejszenie domyślnego poziomu precyzji.
precision mediump float;

uniform sampler2D diffuseTexture;
uniform vec4 lightColour;
uniform vec3 lightPosition;

// Zmienne przekazane z vertex shadera.
varying vec2 interpolatedTexCoord;

// Zdefiniowanie zmiennych jak w vertex shaderze
varying vec3 interpolatedPosition;
varying vec3 interpolatedNormal;
//varying vec4 lightCol;

void main()
{
    // Przypisanie koloru fragmentowi obrazu.
    // gl_FragColor = texture2D(diffuseTexture, interpolatedTexCoord);
    // vec3 lightPosition = vec3(0.0, 2.0, 1.0);
    //vec4 lightColour = vec4(1.0, 1.0, 1.0, 0.2);
    // Długość wektora światła padającego na model w danym fragmencie.
    float distance = length(lightPosition - interpolatedPosition);
    // Znormalizowany wektor kierunku padania światła.
    vec3 lightVector = normalize(lightPosition - interpolatedPosition);
    // Wyznaczenie siły oddziaływania światła za pomocą iloczynu skalarnego.
    // Im mniejsza różnica pomiędzy kątem padania światła a normalną modelu
    // w danym fragmencie,
    // tym silniejsze oddziaływanie światła.
    float diffuse = max( dot(interpolatedNormal, lightVector), 0.0 );
    // Wytłumienie siły oddziaływania światła wraz ze wzrostem odległości.
    diffuse = diffuse * (1.0 / (1.0 + (0.10 * distance)));
    // Doświetlenie modelu światłem ogólnym ("ambient light").
    diffuse = diffuse + 0.2;
    // Wyznaczenie koloru fragmentu poprzez przemnożenie zinterpolowanego
    // koloru modelu w danym fragmencie
    // przez siłę oddziaływania światła oraz kolor na teksturze.
    gl_FragColor = diffuse * lightColour * texture2D(diffuseTexture,
    interpolatedTexCoord);
    gl_FragColor.a = 1.0;

}
