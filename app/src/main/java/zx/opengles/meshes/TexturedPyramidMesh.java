package zx.opengles.meshes;

public class TexturedPyramidMesh extends BaseMesh
{

    public TexturedPyramidMesh()
    {
        float[] triangleVertices =
                {
                        // Przednia ściana
                        0.0f, 1.0f, 0.0f,
                        -1.0f, -1.0f, 1.0f,
                        1.0f, -1.0f, 1.0f,

                        // Prawa ściana
                        0.0f, 1.0f, 0.0f,
                        1.0f, -1.0f, 1.0f,
                        1.0f, -1.0f, -1.0f,

                        // Tylna ściana
                        0.0f, 1.0f, 0.0f,
                        1.0f, -1.0f, -1.0f,
                        -1.0f, -1.0f, -1.0f,

                        // Lewa ściana
                        0.0f, 1.0f, 0.0f,
                        -1.0f, -1.0f, -1.0f,
                        -1.0f, -1.0f, 1.0f,

                        // Dolna ściana
                        1.0f, -1.0f, -1.0f,
                        1.0f, -1.0f, 1.0f,
                        -1.0f, -1.0f, -1.0f,
                        1.0f, -1.0f, 1.0f,
                        -1.0f, -1.0f, 1.0f,
                        -1.0f, -1.0f, -1.0f
                };

        float[] textCoordData =
                {
                        0.5f, 1.0f,
                        0.0f, 0.0f,
                        1.0f, 0.0f,

                        0.5f, 1.0f,
                        0.0f, 0.0f,
                        1.0f, 0.0f,

                        0.5f, 1.0f,
                        0.0f, 0.0f,
                        1.0f, 0.0f,

                        0.5f, 1.0f,
                        0.0f, 0.0f,
                        1.0f, 0.0f,

                        0.0f, 0.0f,
                        0.0f, 1.0f,
                        1.0f, 0.0f,
                        0.0f, 1.0f,
                        1.0f, 1.0f,
                        1.0f, 0.0f
                };

        float[] normalData =
                {
                        // Przednia ściana
                        0.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 1.0f,

                        // Prawa ściana
                        1.0f, 1.0f, 0.0f,
                        1.0f, 1.0f, 0.0f,
                        1.0f, 1.0f, 0.0f,

                        // Tylna ściana
                        0.0f, 1.0f, -1.0f,
                        0.0f, 1.0f, -1.0f,
                        0.0f, 1.0f, -1.0f,

                        // Lewa ściana
                        -1.0f, 1.0f, 0.0f,
                        -1.0f, 1.0f, 0.0f,
                        -1.0f, 1.0f, 0.0f,

                        // Dolna ściana
                        0.0f, -1.0f, 0.0f,
                        0.0f, -1.0f, 0.0f,
                        0.0f, -1.0f, 0.0f,
                        0.0f, -1.0f, 0.0f,
                        0.0f, -1.0f, 0.0f,
                        0.0f, -1.0f, 0.0f
                };

        this.numberOfVertices = triangleVertices.length / 3;

        this.positionBuffer = this.createBuffer(triangleVertices);
        this.texCoordsBuffer = this.createBuffer(textCoordData);
        this.normalBuffer = this.createBuffer(normalData);
    }
}
