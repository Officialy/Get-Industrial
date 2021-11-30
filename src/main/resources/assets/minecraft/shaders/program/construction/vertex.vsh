#version 120

varying vec2 uv;

varying float height;

uniform mat4 matrix;

void main() {
    gl_Position = gl_ModelViewProjectionMatrix*matrix*gl_Vertex;
    uv = gl_MultiTexCoord0.xy;
    height = gl_Vertex.y;
}