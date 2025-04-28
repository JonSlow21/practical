import random
#===================================================================
class RoundRobinLB:
    def __init__(self, servers):
        self.servers, self.i = servers, 0

    def next(self):
        server = self.servers[self.i]
        self.i = (self.i + 1) % len(self.servers)
        return server
#=====================================================================
class LeastConnLB:
    def __init__(self, servers):
        self.conn = {s: 0 for s in servers}

    def next(self):
        server = min(self.conn, key=self.conn.get)
        self.conn[server] += 1
        return server
#======================================================================

servers = ["Server1", "Server2", "Server3"]

#======================================================================

# Round Robin Routing
rr = RoundRobinLB(servers)
print("=== Round Robin Load Balancer ===")
for req in range(1, 6):
    print(f"Request {req}: Routed to {rr.next()}")
    
#====================================================================

print("\n=== Least Connection Load Balancer ===")
# Least Connection Routing
lc = LeastConnLB(servers)

# Add random existing connections to simulate real-world scenario
for _ in range(5):
    lc.conn[random.choice(servers)] += random.randint(1, 3)

for req in range(1, 6):
    server = lc.next()
    print(f"Request {req}: Routed to {server} (Connections: {lc.conn})")