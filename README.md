# Sock

Nowadays, global connectivity generates tremendous amounts of data and increases the need for Real-Time Systems (RTS). These systems consist of hardware and software components that execute tasks under strict timing constraints and are used in a wide variety of applications, such as connected vehicles, smart homes, e-health, and Industry~4.0. While RTS offer enormous opportunities to improve our lives, they also introduce significant security risks. However, the literature has largely neglected time-aware security in periodic task-based RTS, even though time is a crucial factor that directly affects system security. To address this gap, we propose Sock, a clock-based modeling language and toolchain that enables developers to design, execute, and reason about periodic task-based RTS. The operational semantics of Sock are specified using finite state machines equipped with logical clocks for tasks and resource operations. Sock allows the analysis of schedulability and the observation of security-related properties. It integrates confidentiality-preserving mechanisms and supports the simulation of temporal attacks and countermeasures. We evaluate Sock through a set of synthetic task sets and a realistic automotive-inspired case study on which we executed temporal attacks, and show that Sock preserves task schedulability and confidentiality, and reveals abnormal system behavior.

## Concrete Syntax

Sock provides a lightweight textual language to describe systems composed of periodic actors executing on shared resources.
The syntax is implemented with Xtext and follows the philosophy of domain-specific configuration languages: models are intentionally compact, declarative, and focused on timing and resource usage rather than low-level behavior.

The language defines three main concepts:
- System: the container of the model (exactly one per specification)
- Actor: a periodic task with timing and sensitivity attributes
- Resource: a shared execution platform used by actors

This minimal structure keeps models close to classical real-time task descriptions while remaining directly executable by Sock’s semantics.

### Grammar Overview
#### System

A Sock specification contains exactly one System.
It aggregates the actors and resources that compose the modeled application.

```xtext
System returns System:
    {System} "System" name=EString "{"
        ("ownedActor" "{" ownedActor+=Actor ( "," ownedActor+=Actor)* "}" )?
        ("ownedResource" "{" ownedResource+=Resource ( "," ownedResource+=Resource)* "}" )?
    "}";
```

##### Key points

- Identified by a `name`
- May contain:
    - one `ownedActor` block (list of actors)
    - one `ownedResource` block (list of resources)
- Both blocks are optional, allowing partial models during early design

#### Actor

An Actor represents a periodic real-time task bound to a resource.

```xtext
Actor returns Actor:
    {Actor} "Actor" name=EString "{"
        ("isSensitive" isSensitive=EBoolean)
        ("processTime" processTime=EInt)
        ("period" period=EInt)
        ("resource" resource=[Resource|EString])
        ("code" code=EString)?
    "}";
```

##### Attributes

- `isSensitive`: Indicates whether the actor manipulates sensitive data
- `processTime`: Worst-case execution cost (in logical time units)
- `period`: Activation period of the task
- `resource`: Reference to the resource used for execution
- `code` (opt.): External behavioral description used during simulation

The `resource` field is a cross-reference ensuring the actor is mapped to an existing resource.

#### Resource

A Resource models a shared execution unit (e.g., CPU, device).

```xtext
Resource returns Resource:
    {Resource} "Resource" name=EString "{"
        ("actor" "(" actor+=[Actor|EString] ( "," actor+=[Actor|EString])* ")" )?
    "}";
```

##### Key points

- Identified by a `name`
- May optionally list the `actors` allowed to execute on it
- Supports multiple `actors` sharing the same resource

### Example

The following example models a connected heater system composed of three periodic actors sharing a single CPU resource.

```xtext
System ConnectedHeater {
    ownedActor {
        Actor Thermometer {
            isSensitive true
            processTime 5
            period 25
            resource "CPU"
        },
        Actor HeatingDevice {
            isSensitive false
            processTime 8
            period 35
            resource "CPU"
        },
        Actor Monitor {
            isSensitive false
            processTime 2
            period 15
            resource "CPU"
        }
    }
    ownedResource {
        Resource CPU {
            actor (Thermometer, HeatingDevice, Monitor)
        }
    }
}
```

This model specifies:

- Three periodic tasks with different periods and execution costs
- A shared CPU resource
- One task (Thermometer) marked as manipulating sensitive data

##### Design Rationale

Sock’s syntax is deliberately minimal:
- Captures only the structural and temporal information required for schedulability and security reasoning
- Avoids embedding full behavioral logic inside the model
- Keeps specifications analyzable, reproducible, and easy to generate or mutate programmatically