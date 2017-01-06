using UnityEngine;
using System.Collections;

public class infiniteStreet : MonoBehaviour {

    // Use this for initialization
    Vector2 offSet;
    public float speed = 0.5f;
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
        offSet = new Vector2(0, Time.time * speed);
        GetComponent<Renderer>().material.mainTextureOffset = offSet;
	}
}
